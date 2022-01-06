package com.example.embeddedback.dto.device;

import com.example.embeddedback.dto.global.PageinateDto;
import lombok.Data;

@Data
public class SearchDeviceDto extends PageinateDto {
    private Integer id;
    private String name;

    public SearchDeviceDto() {
    }

    public SearchDeviceDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public SearchDeviceDto(Integer id) {
        this.id = id;
    }
}
