package com.example.embeddedback.controller;

import com.example.embeddedback.dto.group.CreateGuestGroupDto;
import com.example.embeddedback.dto.group.CreateGuestGroupMemberDto;
import com.example.embeddedback.dto.group.SearchGuestGroupDto;
import com.example.embeddedback.dto.group.UpdateGuestGroupDto;
import com.example.embeddedback.dto.guest.SearchGuestGroupsDto;
import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.service.GuestGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Api(tags = "访客组模块")
@RestController
@RequestMapping("/guest-group")
public class GuestGroupController {

    @Autowired
    private GuestGroupService guestGroupService;

    @ApiOperation("创建访客组")
    @PostMapping
    Result<Object> create(@RequestBody CreateGuestGroupDto createGuestGroupDto) throws Exception {
        return guestGroupService.create(createGuestGroupDto);
    }

    @ApiOperation("查询访客组")
    @GetMapping
    Result<Object> findAll(SearchGuestGroupDto searchGuestGroupDto) {
        return guestGroupService.findAll(searchGuestGroupDto);
    }

    @ApiOperation("查询单个访客组")
    @GetMapping("/{id}")
    Result<Object> findOne(@PathVariable("id") Integer id) {
        return guestGroupService.findOne(id);
    }

    @ApiOperation("更新访客组")
    @PutMapping
    Result<Object> update(@RequestBody UpdateGuestGroupDto updateGuestGroupDto) throws Exception {
        return guestGroupService.update(updateGuestGroupDto);
    }

    @ApiOperation("删除访客组")
    @DeleteMapping
    Result<Object> remove(@RequestBody UpdateGuestGroupDto updateGuestGroupDto) throws Exception {
        return guestGroupService.remove(updateGuestGroupDto.getId());
    }

    @ApiOperation("查询访客组内成员")
    @GetMapping("/{id}/member")
    Result<Object> findGroupMembers(@PathVariable("id") Integer groupId, SearchGuestGroupsDto searchGuestGroupsDto) {
        return guestGroupService.findAllGroupMembers(groupId, searchGuestGroupsDto);
    }

    @ApiOperation("创建访客组成员")
    @PostMapping("/{id}/member")
    Result<Object> createGroupMember(@PathVariable("id") Integer groupId, @RequestBody CreateGuestGroupMemberDto createGuestGroupMemberDto) throws Exception {
        return guestGroupService.createGroupMember(groupId, createGuestGroupMemberDto.getGuestID());
    }

    @ApiOperation("删除访客组成员")
    @DeleteMapping("/{id}/member")
    Result<Object> deleteGroupMember(@PathVariable("id") Integer groupId, @RequestBody CreateGuestGroupMemberDto createGuestGroupMemberDto) throws Exception {
        return guestGroupService.removeGroupMember(groupId, createGuestGroupMemberDto.getGuestID());
    }
}
