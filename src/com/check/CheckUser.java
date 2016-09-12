package com.check;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.connection.Conn;
import com.user.User;

public class CheckUser {
	public int check(User user){
			Connection  con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			int i =0;
			
			try{
				con=Conn.getConnection();//Á´½ÓÊý¾Ý¿â
				ps=con.prepareStatement("select USERID from Table_1 where USERNAME=? ");
				ps.setString(1,user.getUSERNAME());
			//	ps.setString(2,user.getPASSWORD());
				
				rs=ps.executeQuery();
					while(rs.next()){
						i=1;
					}
			
			    }catch(Exception e){
				e.printStackTrace();
				
			}
return i;
	}
	
	
	}

