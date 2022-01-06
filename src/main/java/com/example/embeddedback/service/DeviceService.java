package com.example.embeddedback.service;

import com.example.embeddedback.dto.device.CreateDeviceDto;
import com.example.embeddedback.dto.device.SearchDeviceDto;
import com.example.embeddedback.dto.device.UpdateDeivceDto;
import com.example.embeddedback.pojo.Result;

public interface DeviceService {
    Result<Object> create(CreateDeviceDto createDeviceDto) throws Exception;

    Result<Object> findAll(SearchDeviceDto searchDeviceDto);

    Result<Object> update(UpdateDeivceDto updateDeivceDto);

    Result<Object> remove(SearchDeviceDto searchDeviceDto) throws Exception;

    Result<Object> findOne(Integer id);
}
