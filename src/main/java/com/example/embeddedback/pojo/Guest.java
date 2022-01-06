package com.example.embeddedback.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "Guest",description = "访客")
public class Guest {
    private int id;
    private String name;
    private String description;
    @JsonBackReference
    private String password;
    private Face[] faces;
}
