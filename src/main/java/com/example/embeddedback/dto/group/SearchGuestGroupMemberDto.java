package com.example.embeddedback.dto.group;

import com.example.embeddedback.dto.global.PageinateDto;
import lombok.Data;

@Data
public class SearchGuestGroupMemberDto extends PageinateDto {
    private Integer guestID;
    private String guestName;
}
