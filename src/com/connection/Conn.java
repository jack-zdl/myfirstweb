package com.connection;

import java.sql.*;

public class Conn {
	//SQL ����
	 public static Connection conn ;
	static String Driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//�������ݿ��ַ
	static String url="jdbc:sqlserver://localhost:1433;databaseName=student";
	static String username="sa";//�û���
	static String password="1993212";//����
	//public  static void  main (String[] args){
	static{//��������
		try {
			Class.forName(Driver);
		//	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=(Connection)DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=student","sa","1993212");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}	
	}
	//�������ݿ�
	 public static  Connection getConnection(){
		Connection  conn=null;
		try {
			conn=(Connection)DriverManager.getConnection(url,username,password);
			//�������ݿ�
			} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("�������ݿ�ʧ��");
			e.printStackTrace();
		}
		return conn;
	}
	
	//�ͷ����� ���������Statement����
	public static void free(ResultSet rs,Connection conn,Statement stmt){
		try{
			if(rs!=null)
				rs.close();
		}catch(SQLException e){
			System.out.println("�ر�ResultSetʧ��");
			e.printStackTrace();
		}finally {
			try{
				if(conn !=null)
					conn.close();
			}catch (SQLException e){
				System.out.println("�ͷ�����ʧ��");
				e.printStackTrace();
				
			}finally{
				try{
					if(stmt !=null)
						stmt.close();//�ر�Statement 
				}catch(SQLException e){
					System.out.println("�ر�Statemnet ʧ��");
					e.printStackTrace();
				}
			}
		}
	}
		public  static void  main (String[] args){
			//����getConnection �Ƿ����ӳɹ�
			Conn.getConnection();
		}
		
		
			
		
	
	}

