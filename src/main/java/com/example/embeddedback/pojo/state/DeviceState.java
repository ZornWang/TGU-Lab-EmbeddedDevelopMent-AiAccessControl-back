package com.example.embeddedback.pojo.state;

public enum DeviceState {
    REGISTER(1,"REGISTER"),
    DETECT_FACE(2,"DETECT_FACE"),
    OPEN(3,"OPEN"),
    WARNING(4,"WARNING"),
    ERROR(5,"ERROR"),;
    private int statusCode;
    private String message;

    DeviceState(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
