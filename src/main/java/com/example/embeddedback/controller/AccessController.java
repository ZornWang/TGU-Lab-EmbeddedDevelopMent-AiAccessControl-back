package com.example.embeddedback.controller;

import com.example.embeddedback.dto.access.CreateAccessDto;
import com.example.embeddedback.dto.access.SearchAccessDto;
import com.example.embeddedback.dto.access.UpdateAccessDto;
import com.example.embeddedback.pojo.Result;
import com.example.embeddedback.service.AccessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "权限管理")
@RestController
@RequestMapping("/access")
public class AccessController {

    @Autowired
    AccessService accessService;

    @ApiOperation("创建访问权限")
    @PostMapping
    public Result<Object> create(@RequestBody CreateAccessDto createAccessDto) throws Exception {
        return accessService.create(createAccessDto);
    }

    @ApiOperation("查询权限")
    @GetMapping
    public Result<Object> findAll(SearchAccessDto searchAccessDto) {
        return accessService.findAll(searchAccessDto);
    }

    @ApiOperation("更新单个访问权限")
    @PutMapping("/{id}")
    public Result<Object> update(@PathVariable("id") Integer id, @RequestBody UpdateAccessDto updateAccessDto) throws Exception {
        return accessService.update(id, updateAccessDto);
    }

    @ApiOperation("删除单个权限")
    @DeleteMapping("/{id}")
    public Result<Object> remove(@PathVariable("id") Integer id) throws Exception {
        return accessService.remove(id);
    }


}
