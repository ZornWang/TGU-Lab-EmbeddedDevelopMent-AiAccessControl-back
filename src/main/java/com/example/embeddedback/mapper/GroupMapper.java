package com.example.embeddedback.mapper;

import com.example.embeddedback.dto.group.SearchGuestGroupDto;
import com.example.embeddedback.dto.group.UpdateGuestGroupDto;
import com.example.embeddedback.pojo.Group;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface GroupMapper {

    void createGroup(Group group);

    Group[] getAllGroup(SearchGuestGroupDto searchGuestGroupDto);

    Integer countGroup(SearchGuestGroupDto searchGuestGroupDto);

    @Select("select * from `group` where id = #{id}")
    Group getGroupById(Integer id);

    void alterGroup(UpdateGuestGroupDto updateGuestGroupDto);

    @Delete("delete from `group` where id = #{id}")
    void deleteGroup(Integer id);

    Group[] getGroupByDeviceId(Integer deviceId);
}
