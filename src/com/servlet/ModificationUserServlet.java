package com.servlet;

import java.io.IOException;


import java.io.PrintWriter;
import java.util.List;







import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;















import com.modification.ModificationUser;
import com.user.User;


//锟斤拷锟斤拷锟阶拷锟斤拷锟斤拷页锟斤拷
public class ModificationUserServlet extends HttpServlet {
	 private static final long serialVersionUID=1L;				
	/**
	 * Constructor of the object.
	System.out.println("到达Modificationservlet页面");

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
		response.setCharacterEncoding("utf-8");
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
		System.out.println("1123456787654321");
		
		
		response.setContentType("text/html"); //锟斤拷锟斤拷锟斤拷锟斤拷
		response.setCharacterEncoding("utf-8");
		
	    PrintWriter out = response.getWriter();    ///留够内存对应的out.free(); out.close();
		
		
		int id=Integer.parseInt(request.getParameter("id"));
	    
	     //User user=new User();
	     ModificationUser mo=new ModificationUser();
	     List<User> list =mo.modificationUser(id);
	     //user=mo.modificationUser(id);
	   request.setAttribute("list",list);
	  
	   request.getRequestDispatcher("modificationuser.jsp").forward(request,response);
			
		out.flush();
		out.close();
		}
	   
	
	public void init() throws ServletException {
		// Put your code here
	}

}
