package com.example.embeddedback.controller;

import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.pojo.User;
import com.example.embeddedback.dto.auth.AuthLoginDto;
import com.example.embeddedback.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "管理")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    public AuthService authService;

    /**
     * 用户登录
     * @param authLoginDto
     * @return
     */
    @ApiOperation("登录")
    @PostMapping("/login")
    public Result<Object> login(@RequestBody AuthLoginDto authLoginDto) {
        return authService.login(authLoginDto);
    }

    /**
     * 退出登录
     *
     * @param user：当前登录的用户
     * @return ResponseData
     */
    @ApiOperation("退出登录")
    @DeleteMapping
    public Result<Object> logout(@ApiIgnore @ModelAttribute("user") User user) {
        return authService.logout(user);
    }

    /**
     * 获取用户信息
     * @param user 当前登录用户
     * @return Result
     */
    @ApiOperation("获取用户信息")
    @GetMapping("/account")
    public Result<Object> account(@ApiIgnore @ModelAttribute("user") User user) {
        return Result.OK(user);
    }

    /**
     * 获取refreshToken
     *
     * @param refreshToken：refreshToken
     * @return token，refreshToken
     */
    @ApiOperation("刷新Token")
    @ApiImplicitParam(name = "refreshToken", value = "refreshToken", required = true, paramType = "query")
    @GetMapping("/refresh")
    public Result<Object> refreshToken(String refreshToken) {
        return authService.refreshToken(refreshToken);
    }

}
