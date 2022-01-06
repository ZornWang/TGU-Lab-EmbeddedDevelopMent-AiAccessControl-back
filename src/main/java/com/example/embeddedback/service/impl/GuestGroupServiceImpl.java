package com.example.embeddedback.service.impl;

import com.example.embeddedback.dto.group.CreateGuestGroupDto;
import com.example.embeddedback.dto.group.SearchGuestGroupDto;
import com.example.embeddedback.dto.group.UpdateGuestGroupDto;
import com.example.embeddedback.dto.guest.SearchGuestDto;
import com.example.embeddedback.dto.guest.SearchGuestGroupsDto;
import com.example.embeddedback.dto.guest.UpdateGuestDto;
import com.example.embeddedback.mapper.GroupMapper;
import com.example.embeddedback.mapper.GuestGroupMapper;
import com.example.embeddedback.pojo.Group;
import com.example.embeddedback.pojo.Guest;
import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.pojo.state.ResponseState;
import com.example.embeddedback.service.GuestGroupService;
import com.example.embeddedback.utils.AliyunService;
import com.example.embeddedback.utils.BaiduApiService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class GuestGroupServiceImpl implements GuestGroupService {

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private GuestGroupMapper guestGroupMapper;

    @Autowired
    private BaiduApiService baiduApiService;

    @Autowired
    private AliyunService aliyunService;

    @Override
    public Result<Object> create(CreateGuestGroupDto createGuestGroupDto) throws Exception {
        if (createGuestGroupDto == null) {
            return Result.error(ResponseState.PARAM_IS_NULL.getMessage(), ResponseState.PARAM_IS_NULL.getStatusCode());
        }
        Group group = new Group(createGuestGroupDto.getName(), createGuestGroupDto.getDescription());
        groupMapper.createGroup(group);
        JSONObject res = baiduApiService.addGroup(Integer.toString(group.getId()));
        if (res.getInt("error_code") != 0 && res.getInt("error_code") != 223101) {
            return Result.error("error form baidu: " + res.getString("error_msg"));
        }
        //        下发配置
        aliyunService.updateDeviceConfig();
        return Result.OK();
    }

    @Override
    public Result<Object> findAll(SearchGuestGroupDto searchGuestGroupDto) {
        Group[] allGroup = groupMapper.getAllGroup(searchGuestGroupDto);
        if (allGroup.length == 0) {
            return Result.OK(allGroup);
        }
        if (searchGuestGroupDto.getCurrent() == null) {
            return Result.OK(allGroup);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("result", allGroup);
        map.put("pageSize", searchGuestGroupDto.getPageSize());
        map.put("current", searchGuestGroupDto.getCurrent());
        map.put("total", groupMapper.countGroup(searchGuestGroupDto));
        return Result.OK(map);

    }

    @Override
    public Result<Object> findOne(Integer id) {
        Group groupById = groupMapper.getGroupById(id);
        if (groupById == null) {
            return Result.error(ResponseState.USER_NOT_EXIST.getMessage(), ResponseState.USER_NOT_EXIST.getStatusCode());
        }
        return Result.OK(groupById);
    }

    @Override
    public Result<Object> update(UpdateGuestGroupDto updateGuestGroupDto) throws Exception {
        groupMapper.alterGroup(updateGuestGroupDto);
        //        下发配置
        aliyunService.updateDeviceConfig();
        return Result.OK();
    }

//    @Transactional
    @Override
    public Result<Object> remove(Integer id) throws Exception {
        JSONObject res = baiduApiService.deleteGroup(Integer.toString(id));
        if (res.getInt("error_code") != 0 && res.getInt("error_code") != 223100) {
            return Result.error("error form baidu: " + res.getString("error_msg"));
        }
        groupMapper.deleteGroup(id);
        //        下发配置
        aliyunService.updateDeviceConfig();
        return Result.OK();
    }

    @Override
    public Result<Object> findAllGroupMembers(Integer groupId, SearchGuestGroupsDto searchGuestGroupsDto) {
        Guest[] allGroupGuests = guestGroupMapper.getAllGroupGuests(groupId, searchGuestGroupsDto);
        if (allGroupGuests.length == 0) {
            return Result.OK(allGroupGuests);
        }
        if (searchGuestGroupsDto.getCurrent() == null) {
            return Result.OK(allGroupGuests);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("result", allGroupGuests);
        map.put("pageSize", searchGuestGroupsDto.getPageSize());
        map.put("current", searchGuestGroupsDto.getCurrent());
        map.put("total", guestGroupMapper.countGroupGuests(groupId, searchGuestGroupsDto));
        return Result.OK(map);
    }

//    @Transactional
    @Override
    public Result<Object> createGroupMember(Integer groupId, Integer gusetId) throws Exception {
//        判断是否重复
        Guest guestFromGuestGroup = guestGroupMapper.getGuestFromGuestGroup(gusetId, groupId);
        if (guestFromGuestGroup != null) {
            return Result.error("用户已经存在与该用户组");
        }
//        同步到百度
        JSONObject res = baiduApiService.addUserToGroup(Integer.toString(gusetId), Integer.toString(groupId));
        if (res.getInt("error_code") != 0 && res.getInt("error_code") != 223103) {
            return Result.error("error form baidu: " + res.getString("error_msg"));
        }
//        写入数据库
        guestGroupMapper.insertGuestGroup(gusetId, groupId);

        //        下发配置
        aliyunService.updateDeviceConfig();
        return Result.OK();
    }

    @Override
    public Result<Object> removeGroupMember(Integer groupId, Integer guestId) throws Exception {
        if (guestId == null) {
            return Result.error("传入用户ID为空");
        }
//            与百度同步
        JSONObject res = baiduApiService.deleteUserFromGroup(Integer.toString(guestId), Integer.toString(groupId));
        if (res.getInt("error_code") != 0 && res.getInt("error_code") != 223103) {
            return Result.error("error form baidu: " + res.getString("error_msg"));
        }
//            从数据库删除
        guestGroupMapper.deleteGroupGuest(groupId, guestId);

        //        下发配置
        aliyunService.updateDeviceConfig();
        return Result.OK();
    }
}
