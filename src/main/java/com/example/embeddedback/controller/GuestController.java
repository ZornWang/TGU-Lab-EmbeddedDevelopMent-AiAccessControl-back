package com.example.embeddedback.controller;

import com.example.embeddedback.dto.global.PageinateDto;
import com.example.embeddedback.dto.guest.UpdateGuestDto;
import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.dto.guest.CreateGuestDto;
import com.example.embeddedback.dto.guest.SearchGuestDto;
import com.example.embeddedback.service.AccessService;
import com.example.embeddedback.service.GuestGroupService;
import com.example.embeddedback.service.GuestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@Api(tags = "访客模块")
@RestController
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @Autowired
    private GuestGroupService guestGroupService;

    @Autowired
    private AccessService accessService;

    @ApiOperation("创建访客")
    @PostMapping
    Result<Object> create(@RequestBody CreateGuestDto createGuestDto) throws Exception {
        return guestService.create(createGuestDto);
    }

    @ApiOperation("查询访客")
    @GetMapping
    Result<Object> findAll( SearchGuestDto searchGuestDto) {
        return guestService.findAll(searchGuestDto);
    }

    @ApiOperation("查询单个访客信息")
    @GetMapping("/{id}")
    Result<Object> findOne(@PathVariable("id") Integer id) {
        return guestService.findOne(id);
    }

    @ApiOperation("更新访客信息")
    @PutMapping
    Result<Object> update(@RequestBody UpdateGuestDto updateGuestDto) throws Exception {
        return guestService.update(updateGuestDto);
    }

    @ApiOperation("删除访客")
    @DeleteMapping
    Result<Object> remove(@RequestBody SearchGuestDto searchGuestDto) throws Exception {
        return guestService.remove(searchGuestDto);
    }

    @ApiOperation("查询访客所属用户组")
    @GetMapping("/{id}/group")
    Result<Object> findGuestGroups(@PathVariable("id") Integer guestID, SearchGuestDto searchGuestDto) {
        return guestService.findGuestGroups(guestID,searchGuestDto);
    }

    @ApiOperation("添加访客到用户组")
    @PostMapping("/{id}/group")
    Result<Object> addGuestToGroup(@PathVariable("id") Integer guestID, @RequestBody Map<String,Object> groupID) throws Exception {
        return guestGroupService.createGroupMember((Integer) groupID.get("groupID"), guestID);
    }

    @ApiOperation("将访客从用户组删除")
    @DeleteMapping("/{id}/group")
    Result<Object> deleteGuestFromGroup(@PathVariable("id") Integer guestID, @RequestBody Map<String,Object> groupID) throws Exception {
        return guestGroupService.removeGroupMember((Integer) groupID.get("groupID"), guestID);
    }

    @ApiOperation("查询用户可访问设备")
    @GetMapping("/{id}/device")
    Result<Object> getGuestAccessibleDevices(@PathVariable("id") Integer guestID, PageinateDto pageinateDto) {
        return accessService.getGuestAccessibleDevices(guestID, pageinateDto);
    }
}
