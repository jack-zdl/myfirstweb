package com.servlet;

import java.io.IOException;


import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.add.AddUser;
import com.user.User;





//�����ע�����ҳ��
public class AddUserServlet extends HttpServlet {
	 private static final long serialVersionUID=1L;			
	/**
	 * Constructor of the object.
	

	/**
	 * Destruction of the servlet. <br>
	 */
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
		String name=request.getParameter("USERNAME"); //���ҳ��õ���USERNAME
		String password=request.getParameter("password");//���ҳ��õ���PASSWORD
		String  sex=request.getParameter("SEX");
		String age=request.getParameter("AGE");
		String birthday=request.getParameter("BIRTHDAY");
		boolean mag=false;
		
		System.out.println("name="+name+"|"+"password="+password);
		
		User user=new User();
		
		user.setUSERNAME(name);
		user.setPASSWORD(password);
		user.setSEX(sex);
		user.setAGE(age);
		user.setBIRTHDAY(birthday);
		
		
		AddUser add=new  AddUser();
		int i=add.adduser(user);
		
		  if(i!= 0){
				 
			  mag=true;
			}else{	
				  mag=false;
			}
//		  try{
//			  
//		  }catch(Exception e){
//			  e.printStackTrace();
//		  }
		  
		out.print(mag);    
		out.flush();
		out.close();
	}



	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
