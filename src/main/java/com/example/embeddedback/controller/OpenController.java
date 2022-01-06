package com.example.embeddedback.controller;

import com.example.embeddedback.dto.open.DeviceDetectFaceDto;
import com.example.embeddedback.dto.open.DeviceOpenDto;
import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.pojo.User;
import com.example.embeddedback.service.OpenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Api(tags = "设备连接模块")
@RestController
@RequestMapping("/open")
public class OpenController {
    @Autowired
    private OpenService openService;


    /**
     * 设备拉取配置
     * @param user
     * @return
     */
    @ApiOperation("设备获取配置")
    @GetMapping("/common/config")
    public Result<Object> getConfig(@ModelAttribute User user) {
        return openService.getDeviceConfig(user.getId());
    }

    /**
     * 设备上电注册
     * @param user
     * @return
     */
    @ApiOperation("设备上电注册")
    @PostMapping("/common/register")
    public Result<Object> register(@ModelAttribute User user) {
        openService.deviceRegister(user.getId());
        return Result.OK(user);
    }

    /**
     * 设备上传人脸识别记录
     * @param user
     * @param file
     * @param deviceDetectFaceDto
     * @return
     */
    @ApiOperation("设备上传人脸识别记录")
    @PostMapping("/event/face/detect")
//    @Async
    public Result<Object> handleDeviceDetectFace(@ModelAttribute User user, @RequestParam MultipartFile file,
                                                 @ModelAttribute DeviceDetectFaceDto deviceDetectFaceDto) throws IOException {
        return openService.deviceDetectFace(user.getId(), file, deviceDetectFaceDto);
    }

    /**
     * 设备上传开锁记录
     * @param user
     * @param deviceOpenDto
     * @return
     */
    @ApiOperation("设备上传开锁记录")
    @PostMapping("/event/door/open")
//    @Async
    public Result<Object> handleDeviceOpen(@ModelAttribute User user, @ModelAttribute("deviceOpenDto") DeviceOpenDto deviceOpenDto) {
        return openService.deviceOpen(user.getId(),deviceOpenDto);
    }
}
