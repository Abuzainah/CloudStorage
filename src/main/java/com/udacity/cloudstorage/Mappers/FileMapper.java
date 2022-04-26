package com.udacity.cloudstorage.Mappers;

import com.udacity.cloudstorage.Models.File;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMapper {

    @Select("select * from files where fileId = #{fileId}")
    File getFileByFileId(Integer fileId);

    @Select("select * from files where fileName = #{fileName}")
    File getFileByFileName(String fileName);

    @Select("select * from files where userId = #{userId}")
    List<File>getFilesByUserId(Integer userId);

    @Insert("insert into files (fileName , contentType , fileSize , userId , fileData) " +
            "values (#{fileName} , #{contentType} , #{fileSize} , #{userId} , #{fileData})")
    @Options(useGeneratedKeys = true , keyProperty = "fileId")
    int insertFile(File file);

    @Delete("delete from files where fileId = #{fileId}")
    void deleteFileById(Integer fileId);
}
