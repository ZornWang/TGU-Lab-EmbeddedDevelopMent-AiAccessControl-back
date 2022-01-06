package com.example.embeddedback.dto.access;

import com.example.embeddedback.dto.global.PageinateDto;
import lombok.Data;

@Data
public class SearchAccessDto extends PageinateDto {
    private Integer id;
    private Integer deviceID;
    private Integer groupID;
}
