package com.lan.backend.Mapper;

import com.lan.backend.DTO.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {
    @Insert("insert into post(user_id, title, content, edit_time, font_id)" +
            "values(#{userId}, #{title}, #{content}, #{editTime}, #{fontId})")
    @Options(useGeneratedKeys = true, keyProperty = "postId")
    int insertPost(Post post);

    @Select("select * from post")
    List<Post> getPosts();
}
