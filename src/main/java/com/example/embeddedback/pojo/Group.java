package com.example.embeddedback.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "Group",description = "访客组")
public class Group {
    private int id;
    private String name;
    private String description;
    private Guest[] guests;
    private GuestGroupAccess[] guestGroupAccesses;

    public Group() {
    }

    public Group(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Group(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
