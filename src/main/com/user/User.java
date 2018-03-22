package com.user;

import java.sql.Date;

public class User {
	private int USERID;
	private String USERNAME;
	private String PASSWORD;
	private Date ADDTIME;
	private String SEX;
	private String  AGE;
    private String  BIRTHDAY;
	
	
	
	
	
	public String getSEX() {
		return SEX;
	}
	public void setSEX(String sEX) {
		SEX = sEX;
	}
	public String getAGE() {
		return AGE;
	}
	public void setAGE(String aGE) {
		AGE = aGE;
	}
	public String getBIRTHDAY() {
		return BIRTHDAY;
	}
	public void setBIRTHDAY(String bIRTHDAY) {
		BIRTHDAY = bIRTHDAY;
	}
	public int getUSERID() {
		return USERID;
	}
	public void setUSERID(int string) {
		USERID = string;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public Date getADDTIME() {
		return ADDTIME;
	}
	public void setADDTIME(Date string) {
		ADDTIME = string;
	}
	
	

}
