package com.example.embeddedback.service;

import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.pojo.User;
import com.example.embeddedback.dto.user.SearchUserDto;
import com.example.embeddedback.dto.user.UpdateUserDto;

public interface UserService {
    Result<Object> findAll(SearchUserDto searchUserDto);

    Result<Object> create(User user);

    Result<Object> alter(UpdateUserDto updateUserDto);

    Result<Object> remove(Integer id);
}
