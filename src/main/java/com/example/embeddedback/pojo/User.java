package com.example.embeddedback.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
//@ApiModel(value = "User",description = "用户")
public class User {
//    @ApiModelProperty(value = "用户id")
    private int id;
//    @ApiModelProperty(value = "用户名")
    private String name;
    @JsonBackReference
//    @ApiModelProperty(value = "密码")
    private String password;
//    @ApiModelProperty(value = "邮箱")
    private String email;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User(int id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
