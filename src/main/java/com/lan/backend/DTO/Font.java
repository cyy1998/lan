package com.lan.backend.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class Font {
    private int fontId;
    private String fontName;
    private String fontDescription;
    private Date createTime;
    private Date generateTime;
    private int userId;
    private int stage;
}
