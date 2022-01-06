package com.example.embeddedback.controller;

import com.example.embeddedback.dto.deviceLog.SearchDeviceLogDto;
import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.service.DeviceLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Api(tags = "设备日志")
@RestController
@RequestMapping("/device-log")
public class DeviceLogController {
    @Autowired
    private DeviceLogService deviceLogService;

    @ApiOperation("查询日志")
    @GetMapping
    public Result<Object> findAll(SearchDeviceLogDto searchDeviceLogDto) {
        return deviceLogService.findAll(searchDeviceLogDto);
    }

    @GetMapping(value = {"/image/{imageID}"}, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable String imageID) throws IOException {
        return deviceLogService.getLogFaceImage(imageID);
    }
}
