package com.udacity.cloudstorage.Mappers;

import com.udacity.cloudstorage.Models.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("select * from users where username = #{username}")
    User getUserByName(String username);

    @Select("select * from users where userId = #{userId}")
    User getUserById(Integer userId);

    @Insert("insert into users (username , salt , password , firstName , lastName) values " +
            "(#{username} , #{salt} , #{password} , #{firstName} , #{lastName})")
    @Options(useGeneratedKeys = true , keyProperty = "userId")
    int insertUser(User user);

    @Delete("delete from users where userId = #{userId}")
    void deleteUserById(Integer userId);

}
