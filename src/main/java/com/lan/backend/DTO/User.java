package com.lan.backend.DTO;

import lombok.Data;

@Data
public class User {

  private Long userId;
  private String userName;
  private String password;

  public User(String username, String password){
    this.setUserName(username);
    this.setPassword(password);
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
