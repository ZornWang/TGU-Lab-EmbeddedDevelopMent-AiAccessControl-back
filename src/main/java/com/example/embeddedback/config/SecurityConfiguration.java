package com.example.embeddedback.config;

import com.example.embeddedback.interceptor.SimpleAccessDeniedInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//可以自定义哪些被保护哪些不被保护
                .anyRequest().permitAll()//所有请求都可以直接通过
                .and()
                .cors()
//                .and().authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll()//不拦截get请求
                .and()
                .csrf().disable()
                // 基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.exceptionHandling().accessDeniedHandler(new SimpleAccessDeniedInterceptor());
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        // allow Swagger URL to be accessed without authentication
//        web.ignoring().antMatchers(
//                "/swagger-ui.html",
//                "/v2/api-docs", // swagger api json
//                "/swagger-resources/configuration/ui", // 用来获取支持的动作
//                "/swagger-resources", // 用来获取api-docs的URI
//                "/swagger-resources/configuration/security", // 安全选项
//                "/swagger-resources/**",
//                "/static/**"
//        );
//    }
}
