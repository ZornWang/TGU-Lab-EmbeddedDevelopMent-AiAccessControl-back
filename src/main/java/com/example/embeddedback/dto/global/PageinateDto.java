package com.example.embeddedback.dto.global;

import lombok.Data;

@Data
public class PageinateDto {
    public Integer current;
    public Integer pageSize;
}
