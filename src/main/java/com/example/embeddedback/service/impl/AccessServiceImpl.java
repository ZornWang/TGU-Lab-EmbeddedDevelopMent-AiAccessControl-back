package com.example.embeddedback.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.embeddedback.dto.access.CreateAccessDto;
import com.example.embeddedback.dto.access.SearchAccessDto;
import com.example.embeddedback.dto.access.UpdateAccessDto;
import com.example.embeddedback.dto.global.PageinateDto;
import com.example.embeddedback.mapper.AccessMapper;
import com.example.embeddedback.pojo.*;
import com.example.embeddedback.pojo.state.ResponseState;
import com.example.embeddedback.service.AccessService;
import com.example.embeddedback.utils.AliyunService;
import com.example.embeddedback.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccessServiceImpl implements AccessService {
    @Autowired
    private AccessMapper accessMapper;

    @Autowired
    private TimeUtils timeUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AliyunService aliyunService;

    @Override
    public Result<Object> create(CreateAccessDto createAccessDto) throws Exception {
        GuestGroupAccess existsAccess = accessMapper.findExistsAccess(null,createAccessDto.getGuestGroupId(), createAccessDto.getDeviceID());
        if (existsAccess != null) {
            return Result.error(ResponseState.ACCESS_IS_EXIST.getMessage(), ResponseState.ACCESS_IS_EXIST.getStatusCode());
        }
        accessMapper.insertAccess(createAccessDto.getDeviceID(),createAccessDto.getGuestGroupId(), JSONObject.toJSONString(createAccessDto.getAcl()));

//        下发配置
        aliyunService.updateDeviceConfig();
        return Result.OK();
    }

    @Override
    public Result<Object> findAll(SearchAccessDto searchAccessDto) {
        GuestGroupAccess[] allAccess = accessMapper.getAllAccess(searchAccessDto);
        if (allAccess.length == 0) {
            return Result.OK(allAccess);
        }
        if (searchAccessDto.getCurrent() == null) {
            return Result.OK(allAccess);
        }

        for (int j = 0; j < allAccess.length; j++) {
            allAccess[j].setAcl(JSON.parseObject((String) allAccess[j].getAcl()));
        }
        Map<String, Object> map = new HashMap<>();
        map.put("result", allAccess);
        map.put("pageSize", searchAccessDto.getPageSize());
        map.put("current", searchAccessDto.getCurrent());
        map.put("total", accessMapper.countAccess(searchAccessDto));
        return Result.OK(map);
    }

    @Override
    public Result<Object> update(Integer id, UpdateAccessDto updateAccessDto) throws Exception {
        GuestGroupAccess existsAccess = accessMapper.findExistsAccess(id, null, null);
        if (existsAccess == null) {
            return Result.error(ResponseState.ACCESS_NOT_EXIST.getMessage(), ResponseState.ACCESS_NOT_EXIST.getStatusCode());
        }
        if (existsAccess.getDeviceId() == updateAccessDto.getDeviceID() && existsAccess.getGuestGroupId() == updateAccessDto.getGuestGroupId()) {
            return Result.error(ResponseState.ACCESS_IS_EXIST.getMessage(), ResponseState.ACCESS_IS_EXIST.getStatusCode());
        }
        accessMapper.alterAccess(id, updateAccessDto.getDeviceID(), updateAccessDto.getGuestGroupId(), JSONObject.toJSONString(updateAccessDto.getAcl()));
//        下发配置
        aliyunService.updateDeviceConfig();
        return Result.OK();
    }

    @Override
    public Result<Object> remove(Integer id) throws Exception {
        accessMapper.deleteAccess(id);
//        下发配置
        aliyunService.updateDeviceConfig();
        return Result.OK();
    }

    @Override
    public Result<Object> getGuestAccessibleDevices(Integer guestID, PageinateDto pageinateDto) {
        Device[] allDevice = accessMapper.getAccessible(guestID, pageinateDto);
        if (allDevice.length == 0) {
            return Result.OK(allDevice);
        }
        if (pageinateDto.getCurrent() == null) {
            return Result.OK(allDevice);
        }

        for (int j = 0; j < allDevice.length; j++) {
            List<TimeRange> allRanges = new ArrayList<>();
            for (int k = 0; k < allDevice[j].getGuestGroupAccess().size(); k++) {
                GuestGroupAccess guestGroupAccess = allDevice[j].getGuestGroupAccess().get(k);
                JSONObject jsonObject = JSONObject.parseObject((String) guestGroupAccess.getAcl());
                JSONArray timeRange = (JSONArray) jsonObject.get("timeRange");
                for (int l = 0; l < timeRange.size(); l++) {
                    TimeRange range = JSONObject.parseObject(JSONObject.toJSONString(timeRange.get(l)), TimeRange.class);
                    allRanges.add(range);
                }
                allDevice[j].getGuestGroupAccess().get(k).setAcl(JSON.parseObject((String) allDevice[j].getGuestGroupAccess().get(k).getAcl()));
            }
            allDevice[j].setAccessTimeRange(timeUtils.mergeTimeRange(allRanges));
        }
        Map<String, Object> map = new HashMap<>();
        map.put("result", allDevice);
        map.put("pageSize", pageinateDto.getPageSize());
        map.put("current", pageinateDto.getCurrent());
        map.put("total", accessMapper.countAccessible(guestID));
        return Result.OK(map);
    }

    @Override
    public List<AccessibleGuests> getDeviceAccessibleDevices(Integer deviceID) {
        List<AccessibleGuests> guests = new ArrayList<>();
        guests = accessMapper.getAccessibleGuests(deviceID);
        if (guests.size() == 0 || guests == null) {
            return guests;
        }
        for (int i = 0; i < guests.size(); i++) {
//            guests[i].setAccessTimeRange(timeUtils.mergeTimeRange(guests[i].getTimeRanges().getTimeRange()));
            JSONObject jsonObject = JSONObject.parseObject((String) guests.get(i).getAcl());
            JSONArray timeRange = (JSONArray) jsonObject.get("timeRange");
            List<TimeRange> allRanges = new ArrayList<>();
            for (int l = 0; l < timeRange.size(); l++) {
                TimeRange range = JSONObject.parseObject(JSONObject.toJSONString(timeRange.get(l)), TimeRange.class);
                allRanges.add(range);
            }
            for (int l = 0; l < timeRange.size(); l++) {
                TimeRange range = JSONObject.parseObject(JSONObject.toJSONString(timeRange.get(l)), TimeRange.class);
                allRanges.add(range);
            }
            guests.get(i).setAccessTimeRange(timeUtils.mergeTimeRange(allRanges));
//            guests[i].setPassword(passwordEncoder.encode(guests[i].getPassword()));
        }
        return guests;
    }
}
