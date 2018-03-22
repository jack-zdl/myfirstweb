package com.delete;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.connection.Conn;

public class DeleteUser {
	public  void deleteuser(int id){
	Connection con=null;
	PreparedStatement ps=null;
	try{
		con=Conn.getConnection();//閾炬帴椹卞姩鏁版嵁搴�
		String sql ="DELETE FROM Table_1 WHERE USERID=?";
		ps=con.prepareStatement(sql);
		ps.setInt(1,id);
		ps.executeUpdate();
	
		
		
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
	 Conn.free(null,con,ps);
	}
}
}
