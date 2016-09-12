package com.add;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.connection.Conn;
import com.user.User;

public class AddUser {
   public int  adduser( User user){
	   Connection  con=null;
		PreparedStatement ps=null;
	//	ResultSet rs=null;
		int i =0;
		try{
			con=Conn.getConnection();
			/**
			 * 构造时间编辑器
			 */
			 SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				String ADDTIME = sf.format(new Date());
		   String sql="insert into Table_1(USERNAME,PASSWORD,SEX,AGE,BIRTHDAY,ADDTIME) values(?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1,user.getUSERNAME());
			ps.setString(2,user.getPASSWORD());
			ps.setString(3,user.getSEX());
			ps.setString(4,user.getAGE());
			ps.setString(5,user.getBIRTHDAY());
			ps.setString (6,ADDTIME);
			 i=ps.executeUpdate();//executeUpdate�� executeQuery 
		}catch(SQLException e){
		e.printStackTrace();
	   }
		return i;
}
}
