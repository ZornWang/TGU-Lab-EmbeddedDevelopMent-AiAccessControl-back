package com.example.embeddedback.service;

import com.example.embeddedback.dto.access.CreateAccessDto;
import com.example.embeddedback.dto.access.SearchAccessDto;
import com.example.embeddedback.dto.access.UpdateAccessDto;
import com.example.embeddedback.dto.global.PageinateDto;
import com.example.embeddedback.pojo.AccessibleGuests;
import com.example.embeddedback.pojo.Result;

import java.util.List;

public interface AccessService {
    Result<Object> create(CreateAccessDto createAccessDto) throws Exception;

    Result<Object> findAll(SearchAccessDto searchAccessDto);

    Result<Object> update(Integer id, UpdateAccessDto updateAccessDto) throws Exception;

    Result<Object> remove(Integer id) throws Exception;

    Result<Object> getGuestAccessibleDevices(Integer guestID, PageinateDto pageinateDto);

    List<AccessibleGuests> getDeviceAccessibleDevices(Integer deviceID);
}
