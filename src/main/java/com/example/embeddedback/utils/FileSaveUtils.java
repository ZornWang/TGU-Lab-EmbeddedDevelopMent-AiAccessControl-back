package com.example.embeddedback.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileSaveUtils {
    @Value("${file.Url}")
    private String path;

    public String getFaceImagePath(int guestId, String facetoken) {
        return path + "/storage/faces/" + guestId + "/" + facetoken + ".jpg";
    }

    public String getLogImagePath(String fileId) {
        return path + "/storage/logs/images" + fileId + ".jpg";
    }
}
