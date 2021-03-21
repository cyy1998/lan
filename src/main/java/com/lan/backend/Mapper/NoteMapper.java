package com.lan.backend.Mapper;

import com.lan.backend.DTO.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {
    @Insert("insert into note(user_id, title, content, edit_time)" +
            "values(#{userId}, #{title}, #{content}, #{editTime})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    int insertNote(Note note);

    @Select("select * from note where user_id = #{userId}")
    List<Note> getNotes(@Param("userId") long userId);
}
