package com.example.embeddedback.controller;

import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.pojo.User;
import com.example.embeddedback.dto.user.SearchUserDto;
import com.example.embeddedback.dto.user.UpdateUserDto;
import com.example.embeddedback.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户模块")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("创建用户")
    @PostMapping
    public Result<Object> create(@RequestBody User user) {
        return userService.create(user);
    }

    @ApiOperation("搜索用户")
    @GetMapping
    public Result<Object> findAll(SearchUserDto searchUserDto) {
        return userService.findAll(searchUserDto);
    }

    @ApiOperation("修改用户信息")
    @PutMapping
    public Result<Object> alter(@ModelAttribute User olduser, @RequestBody UpdateUserDto updateUserDto) {
        if (updateUserDto.getId() == 0) {
            updateUserDto.setId(olduser.getId());
        }
        return userService.alter(updateUserDto);
    }

    @ApiOperation("删除用户")
    @DeleteMapping
    public Result<Object> remove(@ModelAttribute User user, @RequestBody SearchUserDto searchUserDto) {
//        不能删除自己
        if (user.getId() == searchUserDto.getId()) {
            return Result.error();
        }
        return userService.remove(searchUserDto.getId());
    }
}
