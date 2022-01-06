package com.example.embeddedback.dto.guest;

import lombok.Data;

@Data
public class CreateGuestDto {
    public String name;
    public String description;
    public String password;
}
