package com.example.embeddedback.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "Device",description = "设备")
public class Device {
    private int id;
    private String name;
    private String description;
    private String aliyunDeviceName;
    private String aliyunProductKey;
    private String aliyunDeviceSecret;
    private String aliyunIotId;
    private List<GuestGroupAccess> guestGroupAccess;
    private List<TimeRange> accessTimeRange;

    public Device() {
    }

    public Device(String name, String description, String aliyunDeviceName, String aliyunProductKey, String aliyunDeviceSecret, String aliyunIotId) {
        this.name = name;
        this.description = description;
        this.aliyunDeviceName = aliyunDeviceName;
        this.aliyunProductKey = aliyunProductKey;
        this.aliyunDeviceSecret = aliyunDeviceSecret;
        this.aliyunIotId = aliyunIotId;
    }

    public Device(int id, String name, String description, String aliyunDeviceName, String aliyunProductKey, String aliyunDeviceSecret, String aliyunIotId, List<GuestGroupAccess> guestGroupAccess) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.aliyunDeviceName = aliyunDeviceName;
        this.aliyunProductKey = aliyunProductKey;
        this.aliyunDeviceSecret = aliyunDeviceSecret;
        this.aliyunIotId = aliyunIotId;
        this.guestGroupAccess = guestGroupAccess;
    }
}
