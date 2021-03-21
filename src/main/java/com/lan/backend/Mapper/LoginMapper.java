package com.lan.backend.Mapper;

import com.lan.backend.DTO.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    @Insert("insert into user(user_name, password) values(#{userName},#{password})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int createUser(User user);

    @Select("select * from user where user_name = #{userName}")
    User findUser(User user);
}
