package com.connection;

import java.sql.*;

public class Conn {
	//SQL 驱动
	 public static Connection conn ;
	static String Driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//连接数据库地址
	static String url="jdbc:sqlserver://localhost:1433;databaseName=student";
	static String username="sa";//用户名
	static String password="1993212";//密码
	//public  static void  main (String[] args){
	static{//加载驱动
		try {
			Class.forName(Driver);
		//	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=(Connection)DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=student","sa","1993212");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}	
	}
	//连接数据库
	 public static  Connection getConnection(){
		Connection  conn=null;
		try {
			conn=(Connection)DriverManager.getConnection(url,username,password);
			//链接数据库
			} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("链接数据库失败");
			e.printStackTrace();
		}
		return conn;
	}
	
	//释放链接 ，结果集，Statement对象
	public static void free(ResultSet rs,Connection conn,Statement stmt){
		try{
			if(rs!=null)
				rs.close();
		}catch(SQLException e){
			System.out.println("关闭ResultSet失败");
			e.printStackTrace();
		}finally {
			try{
				if(conn !=null)
					conn.close();
			}catch (SQLException e){
				System.out.println("释放连接失败");
				e.printStackTrace();
				
			}finally{
				try{
					if(stmt !=null)
						stmt.close();//关闭Statement 
				}catch(SQLException e){
					System.out.println("关闭Statemnet 失败");
					e.printStackTrace();
				}
			}
		}
	}
		public  static void  main (String[] args){
			//测试getConnection 是否连接成功
			Conn.getConnection();
		}
		
		
			
		
	
	}

