package com.example.embeddedback.pojo;

import lombok.Data;

@Data
public class TimeRange {
    String start;
    String end;

    public TimeRange(String start, String end) {
        this.start = start;
        this.end = end;
    }
}
