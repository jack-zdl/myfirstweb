package com.modification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.connection.Conn;
import com.user.User;

public class ModificationUser {
	public List<User> modificationUser (int id){
		User uservo=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<User> list=new ArrayList<User>();
		//er list=new User();
		try{
		con=Conn.getConnection();//链接数据库
	   
		ps=con.prepareStatement("select * from Table_1 where USERID=?");
		ps.setInt(1,id);
		rs=ps.executeQuery();
		if(rs!=null){
			System.out.println("查询有结果");
		}
		while(rs.next()){
			uservo=new User();
			uservo.setUSERID(rs.getInt("USERID"));
			uservo.setUSERNAME(rs.getString("USERNAME"));
			uservo.setPASSWORD(rs.getString("PASSWORD"));
			uservo.setSEX(rs.getString("SEX"));
			uservo.setAGE(rs.getString("AGE"));
			uservo.setBIRTHDAY(rs.getString("BIRTHDAY"));
			uservo.setADDTIME(rs.getDate("ADDTIME"));
			
			
			list.add(uservo);
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Conn.free(rs, con, ps);
		}
		return list;
		
	}
	//以下的无所谓
	public static void main (String[] args){
		ModificationUser mo=new ModificationUser();
		int id=2;
		 List<User> list =mo.modificationUser(id);
		 if(list!=null){
			 System.out.println("youjiguo");
		 }else{
			 System.out.println("youcuowu");
		 }
	}
	
}
