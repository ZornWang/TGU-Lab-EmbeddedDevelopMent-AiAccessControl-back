package com.example.embeddedback.service.impl;

import com.example.embeddedback.mapper.AuthMapper;
import com.example.embeddedback.pojo.ResponseData;
import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.pojo.User;
import com.example.embeddedback.dto.auth.AuthLoginDto;
import com.example.embeddedback.pojo.state.RedisHeader;
import com.example.embeddedback.pojo.state.ResponseState;
import com.example.embeddedback.service.AuthService;
import com.example.embeddedback.utils.Jwtservice;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    public AuthMapper authMapper;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    public StringRedisTemplate stringRedisTemplate;

    @Autowired
    public Jwtservice jwtService;

    /**
     * 用户登录
     *
     * @param authLoginDto
     * @return
     */
    @Override
    public Result<Object> login(AuthLoginDto authLoginDto) {
        User user = authMapper.getUserByName(authLoginDto.getUsername());
        if (user == null) {
            return Result.error(ResponseState.USER_NOT_EXIST.getMessage(), ResponseState.USER_NOT_EXIST.getStatusCode());
        }
        if (!passwordEncoder.matches(authLoginDto.getPassword(), user.getPassword())
            /*!password.equals(user.getPassword())*/) {
            return Result.error(ResponseState.PASSWORD_IS_ERROR.getMessage(), ResponseState.PASSWORD_IS_ERROR.getStatusCode());
        }

//        检查该用户是否在登录时间段内
        String token_exit = stringRedisTemplate.opsForValue().get(RedisHeader.USER_TOKEN.getHeader() + user.getName());
        if (token_exit != null) {
            String refreshToken_exit = stringRedisTemplate.opsForValue().get(RedisHeader.USER_REFRESH_TOKEN.getHeader() + user.getName());
            return Result.OK(new ResponseData(token_exit, refreshToken_exit, "loginUser", user));
        }

        //token
        String token = jwtService.getToken(user);
        String username = user.getName();
        stringRedisTemplate.opsForValue().set(RedisHeader.USER_TOKEN.getHeader() + username, token);
        stringRedisTemplate.expire(RedisHeader.USER_TOKEN.getHeader() + username, 1, TimeUnit.HOURS);
        //refreshToken
        String refreshToken = jwtService.getRefreshToken(user);
        stringRedisTemplate.opsForValue().set(RedisHeader.USER_REFRESH_TOKEN.getHeader() + username, refreshToken);
        stringRedisTemplate.expire(RedisHeader.USER_REFRESH_TOKEN.getHeader() + username, 30, TimeUnit.DAYS);

        return Result.OK(new ResponseData(token, refreshToken, "loginUser", user));

    }

    /**
     * 退出登录
     *
     * @param user
     * @return
     */
    @Override
    public Result<Object> logout(User user) {

        stringRedisTemplate.delete(RedisHeader.USER_TOKEN.getHeader() + user.getName());
        stringRedisTemplate.delete(RedisHeader.USER_REFRESH_TOKEN.getHeader() + user.getName());
        stringRedisTemplate.delete(RedisHeader.REGISTER_CODE.getHeader() + user.getName());
        return Result.OK();

    }

    /**
     * 获取refreshToken
     *
     * @param refreshToken
     * @return
     */
    @Override
    public Result<Object> refreshToken(String refreshToken) {
        User user = null;
        try {
            user = jwtService.getUser(refreshToken);
        } catch (ExpiredJwtException e) {
            return Result.error(ResponseState.TOKEN_NOT_PROVIDE.getMessage(), ResponseState.TOKEN_NOT_PROVIDE.getStatusCode());
        } catch (Exception e) {
            return Result.error(ResponseState.REFRESH_TOKEN_IS_ERROR.getMessage(), ResponseState.REFRESH_TOKEN_IS_ERROR.getStatusCode());
        }

        stringRedisTemplate.delete(RedisHeader.USER_TOKEN.getHeader() + user.getName());
        stringRedisTemplate.delete(RedisHeader.USER_REFRESH_TOKEN.getHeader() + user.getName());

        String newToken = jwtService.getToken(user);
        String phone = user.getName();
        stringRedisTemplate.opsForValue().set(RedisHeader.USER_TOKEN.getHeader() + phone, newToken);
        stringRedisTemplate.expire(RedisHeader.USER_TOKEN.getHeader() + phone, 1, TimeUnit.HOURS);

        String newRefreshToken = jwtService.getRefreshToken(user);
        stringRedisTemplate.opsForValue().set(RedisHeader.USER_REFRESH_TOKEN.getHeader() + phone, newRefreshToken);
        stringRedisTemplate.expire(RedisHeader.USER_REFRESH_TOKEN.getHeader() + phone, 10, TimeUnit.DAYS);

        ResponseData responseData = new ResponseData(ResponseState.SUCCESS.getMessage(), ResponseState.SUCCESS.getStatusCode());
        responseData.setTokens(newToken, newRefreshToken);
        return Result.OK(responseData);
    }
}