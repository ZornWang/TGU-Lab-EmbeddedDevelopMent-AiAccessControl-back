package com.example.embeddedback.service.impl;

import com.example.embeddedback.mapper.FaceMapper;
import com.example.embeddedback.mapper.GuestGroupMapper;
import com.example.embeddedback.pojo.Face;
import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.dto.face.SearchFaceDto;
import com.example.embeddedback.pojo.state.ResponseState;
import com.example.embeddedback.service.FaceService;
import com.example.embeddedback.utils.AliyunService;
import com.example.embeddedback.utils.BaiduApiService;
import com.example.embeddedback.utils.FileSaveUtils;
import com.example.embeddedback.utils.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class FaceServiceImpl implements FaceService {

    @Autowired
    private BaiduApiService baiduApiService;

    @Autowired
    private AliyunService aliyunService;

    @Autowired
    private FaceMapper faceMapper;

    @Autowired
    private GuestGroupMapper guestGroupMapper;

    @Autowired
    private FileSaveUtils fileSaveUtils;

//    @Async
    @Override
    public Result<Object> create(int guestId, MultipartFile file) throws Exception {
        if (!file.getContentType().equals("image/png") && !file.getContentType().equals("image/jpeg")) {
            return Result.error(ResponseState.IMAGE_TYPE_NOT_SUPPORT.getMessage(), ResponseState.IMAGE_TYPE_NOT_SUPPORT.getStatusCode());
        }
        InputStream inputStream = file.getInputStream();
        BufferedImage read = ImageIO.read(inputStream);

//        png转jpg
        if (file.getContentType().equals("image/png")) {
            BufferedImage image = new BufferedImage(read.getWidth(), read.getHeight(), BufferedImage.TYPE_INT_RGB);
            image.createGraphics().drawImage(read, 0, 0, Color.WHITE, null);
            read = image;
//            ImageIO.write(read, "jpg", new File("/Users/zorn/Desktop/1.jpg"));
        }

//        画质压缩
        BufferedImage image = FileUtils.compressPictureByQality(read, read.getWidth(), read.getHeight());
        inputStream.close();

//        转成base64
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);
        Base64.Encoder encoder = Base64.getEncoder();
        String base64 = encoder.encodeToString(outputStream.toByteArray());
        outputStream.close();

//        人脸检测
        JSONObject jsonObject = baiduApiService.detect(base64);
        if (jsonObject.getInt("error_code") != 0) {
            return Result.error("error form baidu: " + jsonObject.getString("error_msg"));
        }
        JSONObject result = jsonObject.getJSONObject("result");
        JSONArray faceList = result.getJSONArray("face_list");
        JSONObject faceListJSONObject = faceList.getJSONObject(0);
        String faceToken = faceListJSONObject.getString("face_token");
//        判断face_token是否存在
        if (faceMapper.faceTokenExists(faceToken)) {
            return Result.error("该照片已存在");
        }

//        注册人脸
//        注册global组
        baiduApiService.addUser(Integer.toString(guestId),null, faceToken);

//        注册其他用户组
        Integer[] groups = guestGroupMapper.getGroupIdfromGuestId(guestId);
        for (Integer group : groups) {
            baiduApiService.addUser(Integer.toString(guestId), Integer.toString(group), faceToken);
        }

//        写入数据库
        faceMapper.insertFace(guestId, faceToken);

//        保存文件到本地
        String path = fileSaveUtils.getFaceImagePath(guestId, faceToken);
        File localFile = new File(path);
        File parentFile = localFile.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        ImageIO.write(image, "jpg", localFile);

        aliyunService.updateDeviceConfig();
        return Result.OK();
    }

    @Override
    public Result<Object> findAll(SearchFaceDto searchFaceDto) {
        Face[] guestFace = faceMapper.getGuestFace(searchFaceDto);
        return Result.OK(guestFace);
    }

    @Override
    public byte[] getFaceImage(String faceToken) throws IOException {
        Face faceByToken = faceMapper.getFaceByToken(faceToken);
        if (faceByToken == null) {
            return null;
        }
        File face = new File(fileSaveUtils.getFaceImagePath(faceByToken.getGuestId(), faceByToken.getFaceToken()));
        FileInputStream inputStream = new FileInputStream(face);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        inputStream.close();
        return bytes;
    }

    @Override
//    @Transactional
    public Result<Object> remove(int id) throws Exception {
//        获取数据库中的人脸信息
        Face faceById = faceMapper.getFaceById(id);

//        百度云global删除
        JSONObject res = baiduApiService.deleteFace(Integer.toString(faceById.getGuestId()), null, faceById.getFaceToken());
        if (res.getInt("error_code") != 0 && res.getInt("error_code") != 223106) {
            return Result.error("error form baidu: " + res.getString("error_msg"));
        }
//        百度云其他用户组删除
        Integer[] groups = guestGroupMapper.getGroupIdfromGuestId(faceById.getGuestId());
        for (Integer group : groups) {
            JSONObject respose = baiduApiService.deleteFace(Integer.toString(faceById.getGuestId()), Integer.toString(group), faceById.getFaceToken());
            if (respose.getInt("error_code") != 0 && respose.getInt("error_code") != 223106) {
                return Result.error("error form baidu: " + respose.getString("error_msg"));
            }
        }

//        数据库删除
        faceMapper.deleteFace(faceById.getId());

        aliyunService.updateDeviceConfig();

//        本地删除
        File file = new File(fileSaveUtils.getFaceImagePath(faceById.getGuestId(), faceById.getFaceToken()));
        if (file.delete()) {
            return Result.OK();
        } else {
            return Result.error("文件删除失败！");
        }

    }

}
