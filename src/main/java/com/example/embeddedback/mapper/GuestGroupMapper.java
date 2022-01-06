package com.example.embeddedback.mapper;

import com.example.embeddedback.dto.guest.SearchGuestGroupsDto;
import com.example.embeddedback.pojo.Group;
import com.example.embeddedback.pojo.Guest;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface GuestGroupMapper {

    Guest getGuestFromGuestGroup(Integer guestId, Integer groupId);

    @Insert("insert into guest_group (guest_id,group_id) values (#{guestId}, #{groupId})")
    void insertGuestGroup(Integer guestId, Integer groupId);

    Guest[] getAllGroupGuests(Integer groupId,SearchGuestGroupsDto searchGuestGroupsDto);

    Integer countGroupGuests(Integer groupId, SearchGuestGroupsDto searchGuestGroupsDto);

    @Delete("delete from guest_group where group_id = #{groupId} and guest_id = #{guestId}")
    void deleteGroupGuest(Integer groupId, Integer guestId);

    @Select("select group_id from guest_group where guest_id = #{guestId}")
    Integer[] getGroupIdfromGuestId(Integer guestId);

}
