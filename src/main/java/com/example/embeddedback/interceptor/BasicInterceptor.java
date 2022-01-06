package com.example.embeddedback.interceptor;

import com.alibaba.fastjson.JSON;
import com.example.embeddedback.mapper.DeviceMapper;
import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.pojo.User;
import com.example.embeddedback.pojo.state.ResponseState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

@Component
public class BasicInterceptor implements HandlerInterceptor {
    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        String authorization = request.getHeader("Authorization");
        String[] authorizations = authorization.split(" ");
        //判断是否为Bearer类型
        if (!authorizations[0].equals("Basic")) {
            //token错误，不是Bearer类型
            String json = JSON.toJSONString(Result.error(ResponseState.AUTH_ERROR.getMessage(), ResponseState.AUTH_ERROR.getStatusCode()));
            response.getWriter().append(json);
            return false;
        }
        String basic = new String(Base64.getDecoder().decode(authorizations[1]), "UTF-8");
        String[] basics = basic.split(":");
        Integer id = deviceMapper.getDeviceIdByAliName(basics[0], basics[1]);
        if (id == null) {
            //设备不存在
            String json = JSON.toJSONString(Result.error(ResponseState.DEVICE_NOT_EXIST.getMessage(), ResponseState.DEVICE_NOT_EXIST.getStatusCode()));
            response.getWriter().append(json);
            return false;
        }
        User user = new User(id, basics[0], basics[1]);
        request.setAttribute("user",user);
        return true;
    }
}
