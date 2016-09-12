package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//����ǵ�½����ҳ��

public class  LoginServlet extends HttpServlet {
	 private static final long serialVersionUID=1L;				
	/**
	 * Constructor of the object.
	

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doget(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		     this.doPost(request, response);
		     out.flush();
				out.close();
	}
	

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html"); //��������
		
		
		PrintWriter out = response.getWriter();    ////���ҳ�����
		String username=request.getParameter("USERNAME"); 
		
		String password=request.getParameter("PASSWORD");//���ҳ��õ���PASSWORD
		Connection  conn=null;
	    PreparedStatement pt =null;
	    ResultSet rs=null;
	    boolean flag=false;
	  
	   
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//
			conn=(Connection)DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=student","sa","1993212");
		  
		    pt = conn.prepareStatement("SELECT * FROM Table_1 WHERE USERNAME=? AND PASSWORD=?");
		   
		
			
			 pt.setString(1,username);
			 pt.setString(2,password);
			 rs=pt.executeQuery();
			
			if(rs.next()){
				flag=true;
			
			}else{
				flag=false;
			}
			
		  //  pstmt.setString(1, );
		  //  pstmt.setString(2, );
		   // }//����ҳ��
		}catch (Exception e){
			
			e.printStackTrace();
			flag=false;
		}
		
		
		out.print(flag);
		System.out.println(flag);
		out.flush();
		out.close();
	}


	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	

	
	public void init() throws ServletException {
		// Put your code here
	}

}
