package com.example.embeddedback.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.embeddedback.dto.deviceLog.SearchDeviceLogDto;
import com.example.embeddedback.dto.open.DeviceDetectFaceDto;
import com.example.embeddedback.dto.open.DeviceOpenDto;
import com.example.embeddedback.mapper.DeviceLogMapper;
import com.example.embeddedback.pojo.DeviceLog;
import com.example.embeddedback.pojo.Face;
import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.pojo.state.DeviceState;
import com.example.embeddedback.service.DeviceLogService;
import com.example.embeddedback.utils.FileSaveUtils;
import com.example.embeddedback.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class DeviceLogServiceImpl implements DeviceLogService {

    @Autowired
    private DeviceLogMapper deviceLogMapper;

    @Autowired
    private FileSaveUtils fileSaveUtils;

    @Override
    @Transactional
//    @Async
    public void addDeviceLogRegister(Integer deviceId) {
        DeviceLog deviceLog = new DeviceLog();
        deviceLog.setDeviceId(deviceId);
        deviceLog.setEventStatus(DeviceState.REGISTER.getStatusCode());
        deviceLogMapper.createLog(deviceLog);
    }

    @Override
//    @Async
    public Result<Object> addDeviceLogFaceDetect(Integer deviceId, MultipartFile file, DeviceDetectFaceDto deviceDetectFaceDto) throws IOException {
//        读取文件输入流
        InputStream inputStream = file.getInputStream();
        BufferedImage read = ImageIO.read(inputStream);
////        png转jpg
//        if (file.getContentType().equals("image/png")) {
//            BufferedImage image = new BufferedImage(read.getWidth(), read.getHeight(), BufferedImage.TYPE_INT_RGB);
//            image.createGraphics().drawImage(read, 0, 0, Color.WHITE, null);
//            read = image;
////            ImageIO.write(read, "jpg", new File("/Users/zorn/Desktop/1.jpg"));
//        }
//        画质压缩
        BufferedImage image = FileUtils.compressPictureByQality(read, read.getWidth(), read.getHeight());
        inputStream.close();

//        保存文件到本地
//        保存UUID
        String fileID = UUID.randomUUID().toString();
        String path = fileSaveUtils.getLogImagePath(fileID);
        File localFile = new File(path);
        File parentFile = localFile.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        ImageIO.write(image, "jpg", localFile);

//        日志写入数据库
        DeviceLog log = new DeviceLog(deviceId, deviceDetectFaceDto.getGuestID(), DeviceState.DETECT_FACE.getStatusCode());
        Map<String, Object> payload = new HashMap<>();
        payload.put("imageID", fileID);
        payload.put("faceToken", deviceDetectFaceDto.getFaceToken());
        log.setPayload(JSONObject.toJSONString(payload));

        deviceLogMapper.createLog(log);

        return Result.OK();
    }

    @Override
//    @Async
//    @Transactional
    public Result<Object> addDeviceLogDoorOpen(Integer deviceId, DeviceOpenDto deviceOpenDto) {
        DeviceLog log = new DeviceLog(deviceId, deviceOpenDto.getGuestID(), DeviceState.OPEN.getStatusCode());
        Map<String, Object> payload = new HashMap<>();
        payload.put("method", deviceOpenDto.getMethod());
        log.setPayload(JSONObject.toJSONString(payload));
        deviceLogMapper.createLog(log);
        return Result.OK();
    }

    @Override
    public Result<Object> findAll(SearchDeviceLogDto searchDeviceLogDto) {
        if (searchDeviceLogDto.getEvent() != null) {
            for (DeviceState deviceState : DeviceState.values()) {
                if (searchDeviceLogDto.getEvent().toString().equals(deviceState.getMessage())) {
                    searchDeviceLogDto.setEvent((Integer) deviceState.getStatusCode());
                    break;
                }
            }
        }
        DeviceLog[] allLog = deviceLogMapper.getAllLog(searchDeviceLogDto);
        if (allLog.length == 0) {
            return Result.OK(allLog);
        }
        for (int j = 0; j < allLog.length; j++) {
            for (DeviceState deviceState : DeviceState.values()) {
                if (deviceState.getStatusCode() == allLog[j].getEventStatus()) {
                    allLog[j].setEvent(deviceState.getMessage());
                    break;
                }
            }
            allLog[j].setPayload(JSON.parseObject((String) allLog[j].getPayload()));
        }
        if (searchDeviceLogDto.getCurrent() == null) {
            return Result.OK(allLog);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("result", allLog);
        map.put("pageSize", searchDeviceLogDto.getPageSize());
        map.put("current", searchDeviceLogDto.getCurrent());
        map.put("total", deviceLogMapper.countAll(searchDeviceLogDto));
        return Result.OK(map);
    }

    @Override
    public byte[] getLogFaceImage(String imageID) throws IOException {
        if (imageID == null) {
            return null;
        }
        File face = new File(fileSaveUtils.getLogImagePath(imageID));
        FileInputStream inputStream = new FileInputStream(face);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        inputStream.close();
        return bytes;
    }
}
