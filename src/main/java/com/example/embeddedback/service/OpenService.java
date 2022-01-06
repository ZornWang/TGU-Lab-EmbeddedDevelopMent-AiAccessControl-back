package com.example.embeddedback.service;

import com.example.embeddedback.dto.open.DeviceDetectFaceDto;
import com.example.embeddedback.dto.open.DeviceOpenDto;
import com.example.embeddedback.pojo.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface OpenService {
    /**
     * 设备获取配置信息
     * 包含：基本信息、百度云连接方式、百度云用户组 id 列表、用户列表（含授权时间段）
     * @param deviceId
     * @return
     */
    Result<Object> getDeviceConfig(Integer deviceId);

    void deviceRegister(Integer deviceId);

    Result<Object> deviceDetectFace(Integer deviceId, MultipartFile file, DeviceDetectFaceDto deviceDetectFaceDto) throws IOException;

    Result<Object> deviceOpen(Integer deviceId, DeviceOpenDto deviceOpenDto);
}
