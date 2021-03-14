package com.lan.backend.Mapper;

import com.lan.backend.DTO.Font;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FontMapper {
    @Insert("insert into font(font_name,font_description,user_id,stage) values(#{fontName},#{fontDescription},#{userId},0)")
    @Options(useGeneratedKeys = true, keyProperty = "fontId")
    int create(Font font);

    @Select("select * from font where user_id=#{userId}")
    List<Font> getFonts(@Param("userId") int userId);
}
