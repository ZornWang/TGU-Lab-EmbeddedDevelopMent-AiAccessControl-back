package com.example.embeddedback.service;

import com.example.embeddedback.dto.guest.UpdateGuestDto;
import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.dto.guest.CreateGuestDto;
import com.example.embeddedback.dto.guest.SearchGuestDto;

public interface GuestService {

    Result<Object> create(CreateGuestDto createGuestDto) throws Exception;

    Result<Object> findAll(SearchGuestDto searchGuestDto);

    Result<Object> findOne(Integer id);

    Result<Object> update(UpdateGuestDto updateGuestDto) throws Exception;

    Result<Object> remove(SearchGuestDto searchGuestDto) throws Exception;

    Result<Object> findGuestGroups(Integer id, SearchGuestDto searchGuestDto);

}
