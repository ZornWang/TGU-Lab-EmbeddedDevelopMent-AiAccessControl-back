package com.example.embeddedback.dto.guest;

import com.example.embeddedback.dto.global.PageinateDto;
import lombok.Data;

@Data
public class SearchGuestGroupsDto extends PageinateDto {
    private String guestId;
    private String name;
}
