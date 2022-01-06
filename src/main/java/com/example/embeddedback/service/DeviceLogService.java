package com.example.embeddedback.service;

import com.example.embeddedback.dto.deviceLog.SearchDeviceLogDto;
import com.example.embeddedback.dto.open.DeviceDetectFaceDto;
import com.example.embeddedback.dto.open.DeviceOpenDto;
import com.example.embeddedback.pojo.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DeviceLogService {
    /**
     * 设备上报注册事件
     * @param deviceId
     * @return
     */
    void addDeviceLogRegister(Integer deviceId);

    /**
     * 设备上报人脸识别事件
     *
     * @param deviceId
     * @return
     */
    Result<Object> addDeviceLogFaceDetect(Integer deviceId, MultipartFile file, DeviceDetectFaceDto deviceDetectFaceDto) throws IOException;

    /**
     * 设备上报开锁事件
     * @param deviceId
     * @return
     */
    Result<Object> addDeviceLogDoorOpen(Integer deviceId, DeviceOpenDto deviceOpenDto);

    /**
     * 设备日志查询
     * @return
     */
    Result<Object> findAll(SearchDeviceLogDto searchDeviceLogDto);

    byte[] getLogFaceImage(String imageID) throws IOException;
}
