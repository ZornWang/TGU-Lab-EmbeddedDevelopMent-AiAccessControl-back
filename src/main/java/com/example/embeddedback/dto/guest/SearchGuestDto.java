package com.example.embeddedback.dto.guest;

import com.example.embeddedback.dto.global.PageinateDto;
import lombok.Data;

@Data
public class SearchGuestDto extends PageinateDto{
    private Integer id;
    private String name;
}
