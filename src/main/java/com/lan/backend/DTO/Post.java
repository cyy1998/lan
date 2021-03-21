package com.lan.backend.DTO;


import lombok.Data;

@Data
public class Post {

  private long postId;
  private long userId;
  private String title;
  private String content;
  private java.sql.Timestamp editTime;
  private long fontId;


  public long getPostId() {
    return postId;
  }

  public void setPostId(long postId) {
    this.postId = postId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public java.sql.Timestamp getEditTime() {
    return editTime;
  }

  public void setEditTime(java.sql.Timestamp editTime) {
    this.editTime = editTime;
  }


  public long getFontId() {
    return fontId;
  }

  public void setFontId(long fontId) {
    this.fontId = fontId;
  }

}
