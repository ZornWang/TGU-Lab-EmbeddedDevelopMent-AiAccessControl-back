package com.example.embeddedback.mapper;

import com.example.embeddedback.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
public interface AuthMapper {

    @Select("select * from user where name=#{name};")
    User getUserByName(String name);
}
