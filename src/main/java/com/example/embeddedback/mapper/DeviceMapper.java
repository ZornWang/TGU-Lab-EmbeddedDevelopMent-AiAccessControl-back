package com.example.embeddedback.mapper;

import com.example.embeddedback.dto.device.SearchDeviceDto;
import com.example.embeddedback.dto.device.UpdateDeivceDto;
import com.example.embeddedback.pojo.Device;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface DeviceMapper {
    void insertDevice(Device device);

    Device[] getAllDevice(SearchDeviceDto searchDeviceDto);

    Integer countAllDevice(SearchDeviceDto searchDeviceDto);

    void alterDevice(UpdateDeivceDto updateDeivceDto);

    @Delete("delete from device where id = #{id}")
    void deleteDevice(SearchDeviceDto searchDeviceDto);

    @Select("select * from device where id = #{id}")
    Device getDeviceById(SearchDeviceDto searchDeviceDto);

    @Select("select id from device where aliyun_device_name = #{name} and aliyun_device_secret = #{key}")
    Integer getDeviceIdByAliName(String name, String key);

}
