package com.example.embeddedback.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "返回类")
public class ResponseData {
    @ApiModelProperty("accessToken")
    private String accessToken;
    @ApiModelProperty("refreshToken")
    private String refreshToken;
    @ApiModelProperty("返回数据")
    private Map<String, Object> data = new HashMap<>();

    public ResponseData() {
    }


    public ResponseData(String token, String refreshToken, String key, Object value) {
        this.accessToken = token;
        this.refreshToken = refreshToken;
        this.data.put(key, value);
    }

    public ResponseData(String key, Object value) {
        this.data.put(key, value);
    }


    public void setData(String key, Object value) {
        this.data.put(key, value);
    }

    public Object getData(String key) {
        return this.data.get(key);
    }

    public void setTokens(String token, String refreshToken) {
        this.accessToken = token;
        this.refreshToken = refreshToken;
    }
}