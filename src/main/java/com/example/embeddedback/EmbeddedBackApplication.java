package com.example.embeddedback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.example.embeddedback.mapper")
@SpringBootApplication
//@EnableAsync
public class EmbeddedBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmbeddedBackApplication.class, args);
    }

}
