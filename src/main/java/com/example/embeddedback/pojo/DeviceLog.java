package com.example.embeddedback.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.util.Date;

@Data
public class DeviceLog {
    private Integer id;
    private Integer deviceId;
    private Device device;
    private Integer guestId;
    private Guest guest;
    @JsonBackReference
    private Integer eventStatus;
    private String event;
    private Object payload;
    private Date createdAt;

    public DeviceLog() {
    }

    public DeviceLog(Integer id, Integer deviceId, Integer guestId, Integer eventStatus, Object payload, Date creatAt) {
        this.id = id;
        this.deviceId = deviceId;
        this.guestId = guestId;
        this.eventStatus = eventStatus;
        this.payload = payload;
        this.createdAt = creatAt;
    }

    public DeviceLog(Integer deviceId, Integer guestId, Integer eventStatus) {
        this.deviceId = deviceId;
        this.guestId = guestId;
        this.eventStatus = eventStatus;
    }
}
