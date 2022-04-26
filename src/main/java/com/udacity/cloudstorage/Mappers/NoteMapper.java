package com.udacity.cloudstorage.Mappers;

import com.udacity.cloudstorage.Models.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {

    @Select("select * from notes where noteId = #{noteId}")
    Note getNoteById(Integer noteId);

    @Select("select * from notes where userId = #{userId}")
    List<Note>getNotesByUserId(Integer userId);

    @Delete("delete from notes where noteId = #{noteId}")
    void deleteNoteById(Integer noteId);

    @Insert("insert into notes (noteTitle , noteDescription) values (#{noteTitle} , #{noteDescription})")
    @Options(useGeneratedKeys = true , keyProperty = "noteId")
    int insertNote(String noteTitle , String noteDescription);

    @Update("update notes set noteTitle = #{noteTitle} , noteDescription = #{noteDescription}" +
            "where noteId = #{noteId}")
    void updateNote(Integer noteId);
}
