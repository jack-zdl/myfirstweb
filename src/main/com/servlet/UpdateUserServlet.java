package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modification.UpdateUser;
import com.user.User;

public class UpdateUserServlet extends HttpServlet {
	 private static final long serialVersionUID=1L;	
	/**
	 * Constructor of the object.
	 */
	public UpdateUserServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		this.doPost(request,response);
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int id=Integer.parseInt(request.getParameter("USERID"));
		
		String name=request.getParameter("USERNAME");

	    String password=request.getParameter("PASSWORD");
	    String sex=request.getParameter("SEX");
	    String age=request.getParameter("AGE");
	    String birthday=request.getParameter("BIRTHDAY");
		//Date  addtime=request.getParameter("ADDTIME");
		//调用函数
	   
		User user=new User();
		user.setUSERID(id);
		user.setUSERNAME(name);
		user.setPASSWORD(password);
		user.setSEX(sex);
		user.setAGE(age);
		user.setBIRTHDAY(birthday);
		
		
		//user.setADDTIME("addtime");
		//调用函数
		UpdateUser updateuser=new UpdateUser();
		updateuser.update(user);
		response.sendRedirect("ConsultServlet.so");
		
		
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
