package com.example.embeddedback.service.impl;

import com.alibaba.fastjson.JSON;
import com.aliyun.iot20180120.models.RegisterDeviceResponseBody;
import com.example.embeddedback.dto.device.CreateDeviceDto;
import com.example.embeddedback.dto.device.SearchDeviceDto;
import com.example.embeddedback.dto.device.UpdateDeivceDto;
import com.example.embeddedback.mapper.DeviceMapper;
import com.example.embeddedback.pojo.Device;
import com.example.embeddedback.pojo.Guest;
import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.pojo.state.ResponseState;
import com.example.embeddedback.service.DeviceService;
import com.example.embeddedback.utils.AliyunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private AliyunService aliyunService;

    @Autowired
    private DeviceMapper deviceMapper;

//    @Async
    @Override
    public Result<Object> create(CreateDeviceDto createDeviceDto) throws Exception {
//        aliyun创建设备
        RegisterDeviceResponseBody.RegisterDeviceResponseBodyData res = aliyunService.createDevice();
        if (res == null) {
            return Result.error();
        }
        Device device = new Device(
                createDeviceDto.getName(),
                createDeviceDto.getDescription(),
                res.getDeviceName(),
                res.getProductKey(),
                res.getDeviceSecret(),
                res.getIotId()
        );
        deviceMapper.insertDevice(device);
        return Result.OK(device);
    }

    @Override
    public Result<Object> findAll(SearchDeviceDto searchDeviceDto) {
        Device[] allDevice = deviceMapper.getAllDevice(searchDeviceDto);
        if (allDevice.length == 0) {
            return Result.OK(allDevice);
        }
        if (searchDeviceDto.getCurrent() == null) {
            return Result.OK(allDevice);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("result", allDevice);
        map.put("pageSize", searchDeviceDto.getPageSize());
        map.put("current", searchDeviceDto.getCurrent());
        map.put("total", deviceMapper.countAllDevice(searchDeviceDto));
        return Result.OK(map);
    }

    @Override
    public Result<Object> update(UpdateDeivceDto updateDeivceDto) {
        deviceMapper.alterDevice(updateDeivceDto);
        return Result.OK();
    }

//    @Async
    @Override
    public Result<Object> remove(SearchDeviceDto searchDeviceDto) throws Exception {
        if (searchDeviceDto.getId() == null) {
            return Result.error("传入id为空");
        }
        Device deviceById = deviceMapper.getDeviceById(searchDeviceDto);
        if (deviceById == null) {
            return Result.error(ResponseState.DEVICE_NOT_EXIST.getMessage(), ResponseState.DEVICE_NOT_EXIST.getStatusCode());
        }
//        从阿里云删除
        boolean b = aliyunService.deleteDevice(deviceById.getAliyunIotId());
        if (!b) {
            return Result.error();
        }
//        从数据库删除
        deviceMapper.deleteDevice(searchDeviceDto);
        return Result.OK();
    }

    @Override
    public Result<Object> findOne(Integer id) {
        Device deviceById = deviceMapper.getDeviceById(new SearchDeviceDto(id));
        return Result.OK(deviceById);
    }
}
