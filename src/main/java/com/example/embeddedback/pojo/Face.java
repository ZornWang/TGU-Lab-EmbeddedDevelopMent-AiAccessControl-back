package com.example.embeddedback.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "Face",description = "人脸")
public class Face {
    private int id;
    private Guest guest;
    private int guestId;
    private String faceToken;

}
