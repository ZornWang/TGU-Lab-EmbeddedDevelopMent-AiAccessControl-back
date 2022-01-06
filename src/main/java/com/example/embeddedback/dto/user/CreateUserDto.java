package com.example.embeddedback.dto.user;

import lombok.Data;

@Data
public class CreateUserDto {
    private String email;
    private String name;
    private String password;
}
