package com.example.embeddedback.dto.deviceLog;

import com.example.embeddedback.dto.global.PageinateDto;
import lombok.Data;

@Data
public class SearchDeviceLogDto extends PageinateDto {
    private Integer id;
    private Integer guestId;
    private Integer deviceId;
    private Object event;
}
