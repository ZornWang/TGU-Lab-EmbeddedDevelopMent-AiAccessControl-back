package com.example.embeddedback.service;

import com.example.embeddedback.dto.group.CreateGuestGroupDto;
import com.example.embeddedback.dto.group.SearchGuestGroupDto;
import com.example.embeddedback.dto.group.UpdateGuestGroupDto;
import com.example.embeddedback.dto.guest.SearchGuestDto;
import com.example.embeddedback.dto.guest.SearchGuestGroupsDto;
import com.example.embeddedback.dto.guest.UpdateGuestDto;
import com.example.embeddedback.pojo.Result;
import io.swagger.models.auth.In;

import java.io.IOException;

public interface GuestGroupService {

    Result<Object> create(CreateGuestGroupDto createGuestGroupDto) throws Exception;

    Result<Object> findAll(SearchGuestGroupDto searchGuestGroupDto);

    Result<Object> findOne(Integer id);

    Result<Object> update(UpdateGuestGroupDto updateGuestGroupDto) throws Exception;

    Result<Object> remove(Integer id) throws Exception;

    Result<Object> findAllGroupMembers(Integer groupId, SearchGuestGroupsDto searchGuestGroupsDto);

    Result<Object> createGroupMember(Integer groupId, Integer gusetId) throws Exception;

    Result<Object> removeGroupMember(Integer groupId, Integer guestId) throws Exception;


}
