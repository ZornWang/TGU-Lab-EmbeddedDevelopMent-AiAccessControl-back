package com.example.embeddedback.controller;

import com.example.embeddedback.dto.device.CreateDeviceDto;
import com.example.embeddedback.dto.device.SearchDeviceDto;
import com.example.embeddedback.dto.device.UpdateDeivceDto;
import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.service.DeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "设备管理")
@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @ApiOperation("创建设备")
    @PostMapping
    public Result<Object> create(@RequestBody CreateDeviceDto createDeviceDto) throws Exception {
        return deviceService.create(createDeviceDto);
    }

    @ApiOperation("查询设备")
    @GetMapping
    public Result<Object> findAll(SearchDeviceDto searchDeviceDto) {
        return deviceService.findAll(searchDeviceDto);
    }

    @ApiOperation("更新设备信息")
    @PutMapping
    public Result<Object> update(@RequestBody UpdateDeivceDto updateDeivceDto) {
        return deviceService.update(updateDeivceDto);
    }

    @ApiOperation("删除设备")
    @DeleteMapping
    public Result<Object> remove(@RequestBody SearchDeviceDto searchDeviceDto) throws Exception {
        return deviceService.remove(searchDeviceDto);
    }

    @ApiOperation("查询单个设备")
    @GetMapping("/{id}")
    public Result<Object> findOne(@PathVariable("id") Integer id) {
        return deviceService.findOne(id);
    }
}
