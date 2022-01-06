package com.example.embeddedback.dto.user;

import com.example.embeddedback.dto.global.PageinateDto;
import lombok.Data;

@Data
public class SearchUserDto extends PageinateDto {
    private Integer id;
    private String email;
    private String name;
}
