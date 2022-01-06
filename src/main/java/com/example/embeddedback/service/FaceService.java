package com.example.embeddedback.service;

import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.dto.face.SearchFaceDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FaceService {

    Result<Object> create(int guestId, MultipartFile file) throws Exception;

    Result<Object> findAll(SearchFaceDto searchFaceDto);

    byte[] getFaceImage(String faceToken) throws IOException;

    Result<Object> remove(int id) throws Exception;
}
