package com.example.embeddedback.service;


import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.pojo.User;
import com.example.embeddedback.dto.auth.AuthLoginDto;

public interface AuthService {
    Result<Object> login(AuthLoginDto authLoginDto);

    Result<Object> logout(User user);

    Result<Object> refreshToken(String refreshToken);



}
