package com.example.embeddedback.mapper;

import com.example.embeddedback.dto.user.SearchUserDto;
import com.example.embeddedback.pojo.User;
import com.example.embeddedback.dto.user.UpdateUserDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    @Insert("insert into user (name,password,email) values (#{name},#{password},#{email})")
    void insertUser(User user);

    @Select("select id from user where name=#{name}")
    Integer getIdByName(String name);

    @Select("select * from user where id = #{id}")
    User getUserById(Integer id);

//    @Select("select * from user where name = #{name}")
//    User getUserByName(String name);
//
//    @Select("select * from user where email = #{email}")
//    User getUserByEmail(String email);
//
//    @Select("select * from user")
//    User[] getAllUsers();

    User[] getUsers(SearchUserDto searchUserDto);

    Integer countUsers(SearchUserDto searchUserDto);

    void alterUser(UpdateUserDto updateUserDto);

    @Delete("delete from user where id = #{id}")
    void deleteUser(Integer id);
}
