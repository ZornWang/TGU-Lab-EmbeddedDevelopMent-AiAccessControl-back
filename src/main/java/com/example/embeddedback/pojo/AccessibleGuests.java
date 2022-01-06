package com.example.embeddedback.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.util.List;

@Data
public class AccessibleGuests {
    private Integer id;
    private String name;
//    @JsonBackReference
    private String password;
    @JsonBackReference
    private Object acl;
    private List<TimeRange> accessTimeRange;
}
