package com.user;

import java.sql.Date;

public class UserArticle {
	private String user;
  private String title;
  private Date ADDTIME;
  private String content;  
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}

public Date getADDTIME() {
	return ADDTIME;
}
public void setADDTIME(Date aDDTIME) {
	ADDTIME = aDDTIME;
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
  
  
}
