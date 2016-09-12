package com.article;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.connection.Conn;
import com.user.UserArticle;

public class AddArticle {
	public int addarticle(UserArticle userarticle){
		//ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=null;
		
		int i=0;
		
		try{
		con=Conn.getConnection();
		 SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			//Date dd = new Date();
			String ADDTIME = sf.format(new Date());
		    
		String sql="insert into question_1(userName,title,content1,addtime) values(?,?,?,?)";
		ps=con.prepareStatement(sql);
		ps.setString(1,userarticle.getUser());
		ps.setString(2,userarticle.getTitle());
		ps.setString(3,userarticle.getContent());
		ps.setString(4,ADDTIME);
		
		i=ps.executeUpdate();
	
		}catch(SQLException e){
			e.printStackTrace();
		}
		return i;
	}
}
