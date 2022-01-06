package com.example.embeddedback.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.embeddedback.dto.guest.UpdateGuestDto;
import com.example.embeddedback.mapper.GuestMapper;
import com.example.embeddedback.pojo.Group;
import com.example.embeddedback.pojo.Guest;
import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.dto.guest.CreateGuestDto;
import com.example.embeddedback.dto.guest.SearchGuestDto;
import com.example.embeddedback.pojo.state.ResponseState;
import com.example.embeddedback.service.GuestService;
import com.example.embeddedback.utils.AliyunService;
import com.example.embeddedback.utils.BaiduApiService;
import io.swagger.models.auth.In;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestMapper guestMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AliyunService aliyunService;

    @Autowired
    private BaiduApiService baiduApiService;

    @Override
    public Result<Object> create(CreateGuestDto createGuestDto) throws Exception {
        if (createGuestDto.getName() == null) {
            return Result.error("用户名不能为空");
        }
        createGuestDto.setPassword(passwordEncoder.encode(createGuestDto.getPassword()));
        guestMapper.insertGuest(createGuestDto);
        //        下发配置
        aliyunService.updateDeviceConfig();
        return Result.OK();
    }

    @Override
    public Result<Object> findAll(SearchGuestDto searchGuestDto) {
        Guest[] allGuests = guestMapper.getAllGuest(searchGuestDto);
        if (allGuests.length == 0) {
            return Result.OK(allGuests);
        }
        if (searchGuestDto.getCurrent() == null) {
            return Result.OK(allGuests);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("result", allGuests);
        map.put("pageSize", searchGuestDto.getPageSize());
        map.put("current", searchGuestDto.getCurrent());
        map.put("total", guestMapper.countAllGuest(searchGuestDto));
        return Result.OK(map);
    }

    @Override
    public Result<Object> findOne(Integer id) {
        if (id == null) {
            return Result.error(ResponseState.PARAM_IS_ERROR.getMessage());
        }
        Guest guestById = guestMapper.getGuestById(id);
        if (guestById == null) {
            return Result.error(ResponseState.USER_NOT_EXIST.getMessage(), ResponseState.USER_IS_EXIST.getStatusCode());
        }
        return Result.OK(guestById);
    }

//    @Transactional
    @Override
    public Result<Object> update(UpdateGuestDto updateGuestDto) throws Exception {
        if (guestMapper.getGuestById(updateGuestDto.getId()) == null) {
            return Result.error(ResponseState.USER_NOT_EXIST.getMessage(), ResponseState.USER_IS_EXIST.getStatusCode());
        }
        if (updateGuestDto.getPassword() != null) {
            updateGuestDto.setPassword(passwordEncoder.encode(updateGuestDto.getPassword()));
        }
        guestMapper.alterGuestById(updateGuestDto);
        //        下发配置
        aliyunService.updateDeviceConfig();
        return Result.OK();
    }

//    @Transactional
    @Override
    public Result<Object> remove(SearchGuestDto searchGuestDto) throws Exception {
        guestMapper.deleteGusetGroupById(searchGuestDto.getId());
        guestMapper.deleteGuestById(searchGuestDto.getId());
//        百度云同步
        baiduApiService.deleteUserFromGroup(Integer.toString(searchGuestDto.getId()), "@ALL");
        //        下发配置
        aliyunService.updateDeviceConfig();
        return Result.OK();
    }

    @Override
    public Result<Object> findGuestGroups(Integer id, SearchGuestDto searchGuestDto) {
        if (id == null) {
            return Result.error("id为空");
        }
        Group[] groupByGuest = guestMapper.getGroupByGuest(id, searchGuestDto);
        if (groupByGuest.length == 0) {
            return Result.OK(groupByGuest);
        }
        if (searchGuestDto.getCurrent() == null) {
            return Result.OK(groupByGuest);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("result", groupByGuest);
        map.put("pageSize", searchGuestDto.getPageSize());
        map.put("current", searchGuestDto.getCurrent());
        map.put("total", guestMapper.countGroupByGuest(id, searchGuestDto));
        return Result.OK(map);

    }
}
