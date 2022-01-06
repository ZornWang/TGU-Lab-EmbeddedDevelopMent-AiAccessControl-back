package com.example.embeddedback.mapper;

import com.example.embeddedback.dto.guest.CreateGuestDto;
import com.example.embeddedback.dto.guest.SearchGuestDto;
import com.example.embeddedback.dto.guest.UpdateGuestDto;
import com.example.embeddedback.pojo.Group;
import com.example.embeddedback.pojo.Guest;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface GuestMapper {

    @Insert("insert into guest (name,description,password) values(#{name},#{description},#{password})")
    void insertGuest(CreateGuestDto createGuestDto);

    Guest[] getAllGuest(SearchGuestDto searchGuestDto);

    Integer countAllGuest(SearchGuestDto searchGuestDto);

    @Select("select * from guest where id = #{id}")
    Guest getGuestById(Integer id);

    void alterGuestById(UpdateGuestDto updateGuestDto);

    @Delete("delete from guest where id = #{id}")
    void deleteGuestById(Integer id);

    @Delete("delete from guest_group where guest_id = #{id}")
    void deleteGusetGroupById(Integer id);

    Group[] getGroupByGuest(Integer id, SearchGuestDto searchGuestDto);

    Integer countGroupByGuest(Integer id, SearchGuestDto searchGuestDto);
}
