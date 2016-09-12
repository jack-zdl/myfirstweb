package com.modification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.connection.Conn;
import com.user.User;

public class UpdateUser {
	public void  update( User user){
		Connection con=null;
		PreparedStatement ps=null;
		try{
			con=Conn.getConnection();
			 SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				//Date dd = new Date();
				String ADDTIME = sf.format(new Date());
				
			String sql="update Table_1 set USERNAME=?,PASSWORD=? ,SEX=?,AGE=?,BIRTHDAY=?,ADDTIME=? where USERID=?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1,user.getUSERNAME());
			ps.setString(2,user.getPASSWORD());
			ps.setString(3,user.getSEX());
			ps.setString(4,user.getAGE());
			ps.setString(5,user.getBIRTHDAY());
			ps.setString(6,ADDTIME);
			ps.setInt(7,user.getUSERID());
			int i=ps.executeUpdate();
			if(i>0){
				System.out.println("修改成功");
			}
			else{
				System.out.println("修改失败");
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
