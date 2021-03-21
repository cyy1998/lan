package com.lan.backend.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Note {

  private long noteId;
  private long userId;
  private String title;
  private String content;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private Date editTime;


  public long getNoteId() {
    return noteId;
  }

  public void setNoteId(long noteId) {
    this.noteId = noteId;
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


  public Date getEditTime() {
    return editTime;
  }

  public void setEditTime(java.sql.Timestamp editTime) {
    this.editTime = editTime;
  }

}
