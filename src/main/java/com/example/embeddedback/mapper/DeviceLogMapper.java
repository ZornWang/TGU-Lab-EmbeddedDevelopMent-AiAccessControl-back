package com.example.embeddedback.mapper;

import com.example.embeddedback.dto.deviceLog.SearchDeviceLogDto;
import com.example.embeddedback.pojo.DeviceLog;
import org.springframework.stereotype.Component;

@Component
public interface DeviceLogMapper {
    void createLog(DeviceLog deviceLog);

    DeviceLog[] getAllLog(SearchDeviceLogDto searchDeviceLogDto);

    Integer countAll(SearchDeviceLogDto searchDeviceLogDto);
}
