package com.udacity.cloudstorage.Mappers;


import com.udacity.cloudstorage.Models.Credential;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CredentialMapper {
    @Select("select * from credentials where credentialId = #{credentialId}")
    Credential getCredentialById(Integer credentialId);

    @Select("select * from credentials where userId = #{userId}")
    List<Credential>getCredentialsByUserId(Integer userId);

    @Delete("delete from credentials where credentialId = #{credentialId}")
    void deleteCredentialById(Integer credentialId);

    @Insert("insert into credentials (url , username , key , password) values (#{url} , #{username} , #{key} , #{password})")
    @Options(useGeneratedKeys = true , keyProperty = "credentialId")
    int insertCredential(Credential credential);

    @Update("update credentials set url = #{url} , username = #{username} , key = #{key} , password = #{password}" +
            "where credentialId = #{credentialId}")
    void updateCredential(Integer credentialId);
}
