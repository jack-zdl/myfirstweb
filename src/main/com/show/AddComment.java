package com.show;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.connection.Conn;

import com.user.UserComment;

public class AddComment {
	public int addcom(UserComment usercomment){
		//ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=null;
		
		int i=0;
		
		try{
		con=Conn.getConnection();
		 SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			//Date dd = new Date();
			String data = sf.format(new Date());
		    
		String sql="insert into comment(titleid,username,comment_content,addtime) values(?,?,?,?)";
		ps=con.prepareStatement(sql);
		ps.setInt(1,usercomment.getTitleid());
		ps.setString(2,usercomment.getUser());
		ps.setString(3,usercomment.getContent());
		ps.setString(4,data);
		
		i=ps.executeUpdate();
	
		}catch(SQLException e){
			e.printStackTrace();
		}
		return i;
	}
}
