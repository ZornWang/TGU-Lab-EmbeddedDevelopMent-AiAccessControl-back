package com.example.embeddedback;

import com.example.embeddedback.dto.deviceLog.SearchDeviceLogDto;
import com.example.embeddedback.mapper.DeviceLogMapper;
import com.example.embeddedback.pojo.AccessibleGuests;
import com.example.embeddedback.pojo.DeviceLog;
import com.example.embeddedback.service.AccessService;
import com.example.embeddedback.utils.AliyunService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmbeddedBackApplicationTests {

    @Autowired
    private AliyunService aliyunService;

    @Autowired
    private AccessService accessService;

    @Autowired
    private DeviceLogMapper deviceLogMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testAliyun() throws Exception {
        aliyunService.updateDeviceConfig();
    }

    @Test
    void testLimit() {
        SearchDeviceLogDto searchDeviceLogDto = new SearchDeviceLogDto();
//        searchDeviceLogDto.setCurrent(1);
//        searchDeviceLogDto.setPageSize(20);
        DeviceLog[] allLogtest = deviceLogMapper.getAllLog(searchDeviceLogDto);
        System.out.println(allLogtest);
    }

}
