package com.show;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.connection.Conn;

import com.user.UserArticle;

public class ShowContent {
		public List<UserArticle> showcontent(){
			Connection con= null;
			PreparedStatement ps= null;
			ResultSet rs=null;
			List<UserArticle> list=new ArrayList<UserArticle>();
			try{
				con=Conn.getConnection();
				String sql="SELECT content FROM question";
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				while(rs.next()){
					UserArticle userarticle=new UserArticle();
					userarticle.setContent(rs.getString("content"));
					list.add(userarticle);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return list;
			
		}
		//转换JSON格式
		public String resultToJson() throws Exception{
			JSONArray ja = new JSONArray();
			Connection con= null;
			PreparedStatement ps= null;
			ResultSet rs=null;
			con=Conn.getConnection();
			String sql="SELECT  (SELECT COUNT(*) FROM comment WHERE titleid=a.id)  AS count , a.id, a.userName,a.title,a.content1,a.addtime  FROM question_1 a";
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
