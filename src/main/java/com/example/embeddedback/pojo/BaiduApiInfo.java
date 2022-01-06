package com.example.embeddedback.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BaiduApiInfo {
    private String APP_ID;
    private String API_KEY;
    private String SECRET_KEY;

    public BaiduApiInfo(String APP_ID, String API_KEY, String SECRET_KEY) {
        this.APP_ID = APP_ID;
        this.API_KEY = API_KEY;
        this.SECRET_KEY = SECRET_KEY;
    }

    @JsonProperty("APP_ID")
    public String getAPP_ID() {
        return APP_ID;
    }

    @JsonProperty("API_KEY")
    public String getAPI_KEY() {
        return API_KEY;
    }

    @JsonProperty("SECRET_KEY")
    public String getSECRET_KEY() {
        return SECRET_KEY;
    }
}
