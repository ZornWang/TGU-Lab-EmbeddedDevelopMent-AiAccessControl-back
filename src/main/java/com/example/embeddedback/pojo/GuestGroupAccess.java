package com.example.embeddedback.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "GuestGroupAccess",description = "访客组权限")
public class GuestGroupAccess {
    private int id;
    private int guestGroupId;
    private Group guestGroup;
    private int deviceId;
    private Device device;
    private Object acl;

    public GuestGroupAccess(int id, int groupId, Group group, int deviceId, Device device, String acl) {
        this.id = id;
        this.guestGroupId = groupId;
        this.guestGroup = group;
        this.deviceId = deviceId;
        this.device = device;
        this.acl = acl;
    }

    public GuestGroupAccess() {
    }
}
