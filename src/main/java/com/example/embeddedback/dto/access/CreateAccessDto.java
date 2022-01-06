package com.example.embeddedback.dto.access;

import com.example.embeddedback.pojo.AccessACL;
import com.example.embeddedback.pojo.TimeRange;
import com.nh.micro.ext.ExtBeanWrapper;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
public class CreateAccessDto {
    public Integer deviceID;
    public Integer guestGroupId;
    public AccessACL acl;
}
