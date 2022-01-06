package com.example.embeddedback.controller;

import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.dto.face.CreateFaceDto;
import com.example.embeddedback.dto.face.SearchFaceDto;
import com.example.embeddedback.service.FaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Api(tags = "人脸模块")
@RestController
@RequestMapping("/face")
public class FaceController {

    @Autowired
    private FaceService faceService;

    @ApiOperation("注册人脸")
    @PostMapping
    public Result<Object> create(@RequestParam MultipartFile file, @ModelAttribute("createFaceDto") CreateFaceDto createFaceDto) throws Exception {
        return faceService.create(Integer.parseInt(createFaceDto.getGuestId()), file);
    }

    @ApiOperation("查询某访客所有人脸")
    @GetMapping
    public Result<Object> findAll(SearchFaceDto searchFaceDto) {
        return faceService.findAll(searchFaceDto);
    }

    @ApiOperation("获取单张人脸照片")
    @GetMapping(value = {"/image/{faceToken}"},produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] findOne(@PathVariable String faceToken) throws IOException {
        return faceService.getFaceImage(faceToken);
    }

    @ApiOperation("删除人脸")
    @DeleteMapping
    public Result<Object> remove(@RequestBody Map<String,Object> param) throws Exception {
        return faceService.remove((Integer) param.get("id"));
    }
}
