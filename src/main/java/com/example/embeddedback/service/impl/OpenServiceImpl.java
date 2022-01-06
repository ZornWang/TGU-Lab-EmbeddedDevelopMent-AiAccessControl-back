package com.example.embeddedback.service.impl;

import com.example.embeddedback.dto.device.SearchDeviceDto;
import com.example.embeddedback.dto.open.DeviceDetectFaceDto;
import com.example.embeddedback.dto.open.DeviceOpenDto;
import com.example.embeddedback.mapper.DeviceMapper;
import com.example.embeddedback.mapper.GroupMapper;
import com.example.embeddedback.pojo.*;
import com.example.embeddedback.service.AccessService;
import com.example.embeddedback.service.DeviceLogService;
import com.example.embeddedback.service.OpenService;
import com.example.embeddedback.utils.BaiduApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OpenServiceImpl implements OpenService {
    @Autowired
    private AccessService accessService;

    @Autowired
    private BaiduApiService baiduApiService;

    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private DeviceLogService deviceLogService;

    @Override
    public Result<Object> getDeviceConfig(Integer deviceId) {
//        获取设备信息
        Device deviceInfo = deviceMapper.getDeviceById(new SearchDeviceDto(deviceId));
//        获取用户组信息
        Group[] groupInfo = groupMapper.getGroupByDeviceId(deviceId);
//        获取百度用户组名
        List<String> baiduGroup = new ArrayList<>();
        for (Group group : groupInfo) {
            baiduGroup.add(baiduApiService.getUserGroupName(Integer.toString(group.getId())));
        }
//        获取百度API配置信息
        BaiduApiInfo baiduApiInfo = baiduApiService.getInfo();
//        获取访客信息
        List<AccessibleGuests> deviceAccessibleDevices = accessService.getDeviceAccessibleDevices(deviceId);

        Map<String,Object> res =new HashMap<>();
        res.put("basicInfo", deviceInfo);

        Map<String, Object> baiduAIP = new HashMap<>();
        baiduAIP.put("config", baiduApiInfo);
        baiduAIP.put("groups", baiduGroup);

        res.put("baiduAIP", baiduAIP);
        res.put("accessibleGroups", groupInfo);
        res.put("accessibleGuests", deviceAccessibleDevices);
        return Result.OK(res);
    }

    @Override
//    @Async
    public void deviceRegister(Integer deviceId) {
        deviceLogService.addDeviceLogRegister(deviceId);
    }

    @Override
//    @Async
    public Result<Object> deviceDetectFace(Integer deviceId, MultipartFile file, DeviceDetectFaceDto deviceDetectFaceDto) throws IOException {
        return deviceLogService.addDeviceLogFaceDetect(deviceId, file, deviceDetectFaceDto);
    }

    @Override
//    @Async
    public Result<Object> deviceOpen(Integer deviceId, DeviceOpenDto deviceOpenDto) {
        return deviceLogService.addDeviceLogDoorOpen(deviceId, deviceOpenDto);
    }
}
