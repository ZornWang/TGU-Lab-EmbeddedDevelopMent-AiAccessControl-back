package com.example.embeddedback.dto.group;

import com.example.embeddedback.dto.global.PageinateDto;
import lombok.Data;

@Data
public class SearchGuestGroupDto extends PageinateDto {
    private Integer id;
    private String name;
}
