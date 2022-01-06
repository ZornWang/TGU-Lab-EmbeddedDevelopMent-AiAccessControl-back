package com.example.embeddedback.mapper;

import com.example.embeddedback.dto.access.CreateAccessDto;
import com.example.embeddedback.dto.access.SearchAccessDto;
import com.example.embeddedback.dto.access.UpdateAccessDto;
import com.example.embeddedback.dto.global.PageinateDto;
import com.example.embeddedback.pojo.AccessibleGuests;
import com.example.embeddedback.pojo.Device;
import com.example.embeddedback.pojo.GuestGroupAccess;
import com.example.embeddedback.pojo.TimeRange;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AccessMapper {

    GuestGroupAccess findExistsAccess(Integer id,Integer groupId, Integer deviceId);

    void insertAccess(Integer deviceId, Integer groupId, String acl);

    GuestGroupAccess[] getAllAccess(SearchAccessDto searchAccessDto);

    Integer countAccess(SearchAccessDto searchAccessDto);

    void alterAccess(Integer id, Integer deviceID, Integer guestGroupId, String acl);

    @Delete("delete from group_device where id = #{id}")
    void deleteAccess(Integer id);

    Device[] getAccessible(Integer id, PageinateDto pageinateDto);

    Integer countAccessible(Integer id);

    List<AccessibleGuests> getAccessibleGuests(Integer id);
}
