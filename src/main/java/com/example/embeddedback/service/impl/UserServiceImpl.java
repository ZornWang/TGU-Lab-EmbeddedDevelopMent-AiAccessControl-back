package com.example.embeddedback.service.impl;

import com.example.embeddedback.mapper.UserMapper;
import com.example.embeddedback.pojo.Guest;
import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.pojo.User;
import com.example.embeddedback.dto.user.SearchUserDto;
import com.example.embeddedback.dto.user.UpdateUserDto;
import com.example.embeddedback.pojo.state.ResponseState;
import com.example.embeddedback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public Result<Object> findAll(SearchUserDto searchUserDto) {
        User[] allUsers = userMapper.getUsers(searchUserDto);
        if (allUsers.length == 0) {
            return Result.OK(allUsers);
        }
        if (searchUserDto.getCurrent() == null) {
            return Result.OK(allUsers);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("result", allUsers);
        map.put("pageSize", searchUserDto.getPageSize());
        map.put("current", searchUserDto.getCurrent());
        map.put("total", userMapper.countUsers(searchUserDto));
        return Result.OK(map);
    }

    @Override
    public Result<Object> create(User user) {
        Integer idByName = userMapper.getIdByName(user.getName());
        if (idByName != null) {
            //该用户已存在
            return Result.error(ResponseState.USER_IS_EXIST.getMessage(), ResponseState.USER_IS_EXIST.getStatusCode());
        }
        if (user.getPassword() == null) {
            return Result.error("未传入密码", ResponseState.ERROR.getStatusCode());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.insertUser(user);
        return Result.OK();
    }

//    @Transactional
    @Override
    public Result<Object> alter(UpdateUserDto updateUserDto) {
        if (updateUserDto == null) {
            //传入参数为空
            return Result.error(ResponseState.PARAM_IS_NULL.getMessage(), ResponseState.PARAM_IS_NULL.getStatusCode());
        }
        if (updateUserDto.getPassword() != null) {
            updateUserDto.setPassword(passwordEncoder.encode(updateUserDto.getPassword()));
        }
        userMapper.alterUser(updateUserDto);
        return Result.OK();
    }

    @Override
    public Result<Object> remove(Integer id) {
        User userById = userMapper.getUserById(id);
        if (userById == null) {
            return Result.error(ResponseState.USER_NOT_EXIST.getMessage(), ResponseState.USER_NOT_EXIST.getStatusCode());
        }
        userMapper.deleteUser(id);
        return Result.OK();
    }
}
