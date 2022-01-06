package com.example.embeddedback.interceptor;

import com.alibaba.fastjson.JSON;
import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.pojo.User;
import com.example.embeddedback.pojo.state.RedisHeader;
import com.example.embeddedback.pojo.state.ResponseState;
import com.example.embeddedback.utils.Jwtservice;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private Jwtservice jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("拦截器工作");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        String authorization = request.getHeader("Authorization");

        if (authorization == null) {
            //未传入token
            String json = JSON.toJSONString(Result.error(ResponseState.TOKEN_NOT_PROVIDE.getMessage(), ResponseState.TOKEN_NOT_PROVIDE.getStatusCode()));
            response.getWriter().append(json);
            return false;
        }

        String[] authorizations = authorization.split(" ");
        //判断是否为Bearer类型
        if (!authorizations[0].equals("Bearer")) {
            //token错误，不是Bearer类型
            String json = JSON.toJSONString(Result.error(ResponseState.TOKEN_IS_ERROR.getMessage(), ResponseState.TOKEN_IS_ERROR.getStatusCode()));
            response.getWriter().append(json);
            return false;
        }

        String token = authorizations[1];
        //判断是否传入token
        if (token == null) {
            //未传入token
            String json = JSON.toJSONString(Result.error(ResponseState.TOKEN_NOT_PROVIDE.getMessage(), ResponseState.TOKEN_NOT_PROVIDE.getStatusCode()));
            response.getWriter().append(json);
            return false;
        }

        try {
            User user = null;
            try {
                user = jwtService.getUser(token, request);
            } catch (Exception e) {
                //token错误，不能正常解析
                e.printStackTrace();
                String json = JSON.toJSONString(Result.error(ResponseState.TOKEN_IS_ERROR.getMessage(), ResponseState.TOKEN_IS_ERROR.getStatusCode()));
                response.getWriter().append(json);
                return false;
            }
            if (user == null) {
                //解析后user为空
                String json = JSON.toJSONString(Result.error());
                response.getWriter().append(json);
                return false;
            }
            //成功解析

            String rightToken = this.stringRedisTemplate.opsForValue().get(RedisHeader.USER_TOKEN.getHeader() + user.getName());
            if (token.equals(rightToken)) {
                return true;
            } else {
                String Json= JSON.toJSONString(Result.error(ResponseState.TOKEN_IS_ERROR.getMessage(), ResponseState.TOKEN_IS_ERROR.getStatusCode()));
                response.getWriter().append(Json);
                return false;
            }

        } catch (ExpiredJwtException e) {
            //token过期
            String Json = JSON.toJSONString(Result.error(ResponseState.TOKEN_IS_EXPIRED.getMessage(), ResponseState.TOKEN_IS_EXPIRED.getStatusCode()));
            response.getWriter().append(Json);
            return false;
        } catch (Exception e) {
            //发生错误
            String json = JSON.toJSONString(Result.error());
            response.getWriter().append(json);
            return false;
        }
    }

}
