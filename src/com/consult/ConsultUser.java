package com.consult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.connection.Conn;
import com.user.User;

public class ConsultUser {
	public List<User> consultUser(int page){
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection con=null;
		List<User> list=new ArrayList<User>();
		try{
			con=Conn.getConnection();
			//int pages=2;   top "+pages+"
			String sql="SELECT  * FROM Table_1 ";
			ps=con.prepareStatement(sql);
			//ps=setInt(1,page);
			rs=ps.executeQuery();
			while(rs.next()){
				User st=new User();
				st.setUSERID(rs.getInt("USERID"));
				st.setUSERNAME(rs.getString("USERNAME"));
				st.setPASSWORD(rs.getString("PASSWORD"));
				st.setSEX(rs.getString("SEX"));
				st.setAGE(rs.getString("AGE"));
				st.setBIRTHDAY(rs.getString("BIRTHDAY"));
				st.setADDTIME(rs.getDate("ADDTIME"));
				
				list.add(st);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		
		return list;
		
	}
}
