package com.example.embeddedback.config;

import com.example.embeddedback.interceptor.BasicInterceptor;
import com.example.embeddedback.interceptor.LoginInterceptor;
import com.example.embeddedback.interceptor.StaticResourceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private StaticResourceInterceptor staticResourceInterceptor;

    @Autowired
    private BasicInterceptor basicInterceptor;

    @Value("${path.static}")
    private String staticPath;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] LoginPaths = {
                "/api/auth/login",
                "/api/auth/refresh",
                "/swagger-ui.html",
                "/swagger-resources/**",
                "/webjars/**",
                "/v2/**",
                "/swagger-ui.html/**",
                "/error",
                "/api/face/image/**",
                "/api/device-log/image/**",
                "/api/open/**",
                "/static/**",
                "/index/**",
                "/"
        };
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns(LoginPaths);
        registry.addInterceptor(staticResourceInterceptor)
                .addPathPatterns("/api/face/image/**");
        registry.addInterceptor(basicInterceptor)
                .addPathPatterns("/api/open/**");

    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        String[] CLASSPATH_RESOURCE_LOCATIONS = {
//                "classpath:/META-INF/resources/", "classpath:/resources/",
//                "classpath:/static/", "classpath:/public/" };

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/"+staticPath+"/**")
                .addResourceLocations("file:"+staticPath+System.getProperty("file.separator"));
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/**")
//                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

//    @Override
//    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
//        WebMvcConfigurer.super.addReturnValueHandlers(handlers);
//    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        WebMvcConfigurer.super.configureMessageConverters(converters);
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer.addPathPrefix("/api", c -> c.isAnnotationPresent(RestController.class) || c.isAnnotationPresent(Controller.class));
//        为controller加前缀会影响swagger页面访问
        configurer.addPathPrefix("/api", c -> c.isAnnotationPresent(RestController.class));
    }
}
