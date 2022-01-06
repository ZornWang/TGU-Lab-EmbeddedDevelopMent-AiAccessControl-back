package com.example.embeddedback.interceptor;

import com.alibaba.fastjson.JSON;
import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.pojo.state.ResponseState;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SimpleAccessDeniedInterceptor implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Result<Object> responseData = Result.error(ResponseState.WITHOUT_PERMISSION.getMessage(), ResponseState.WITHOUT_PERMISSION.getStatusCode());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().append(JSON.toJSONString(responseData));
    }
}
