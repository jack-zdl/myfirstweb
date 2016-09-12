package com.show;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.connection.Conn;

public class ShowComment {
	public String commentToJson() throws Exception{
		JSONArray ja = new JSONArray();
		Connection con= null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		con=Conn.getConnection();
		String sql="SELECT titleid,username,comment_content,addtime  FROM comment ORDER BY addtime";
		ps=con.prepareStatement(sql);
		rs=ps.executeQuery();
		
		//获取行数
		ResultSetMetaData metadata = rs.getMetaData();
		int column = metadata.getColumnCount();//hang数
		while(rs.next()){
			JSONObject jb = new JSONObject();
			for(int i=1;i<=column;i++){
				String columnName=metadata.getColumnLabel(i);//返回列名
				String value=rs.getString(columnName);//
				jb.put(columnName, value);
			}
			ja.add(jb);
		}
		return ja.toString();
	}
}
