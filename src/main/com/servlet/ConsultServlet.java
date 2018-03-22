package com.servlet;

import java.io.IOException;


import java.io.PrintWriter;
import java.util.List;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;










import com.consult.ConsultUser;
import com.user.User;


//锟斤拷锟斤拷锟阶拷锟斤拷锟斤拷页锟斤拷
public class ConsultServlet extends HttpServlet {
	 private static final long serialVersionUID=1L;				
	/**
	 * Constructor of the object.
	

	/**
	 * Destruction of the servlet. <br>
	 */
	@Override
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
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		response.setContentType("text/html"); //锟斤拷锟斤拷锟斤拷锟斤拷
		response.setCharacterEncoding("utf-8");
		
	    PrintWriter out = response.getWriter();    ////锟斤拷锟揭筹拷锟斤拷锟斤拷
		
	   String page1=request.getParameter("page");  //锟斤拷锟揭筹拷娲拷锟斤拷锟斤拷锟街�
	   int page=1;
	   if(page1 !=null){
		   page=Integer.parseInt(page1);  //锟斤拷锟揭筹拷娲拷锟斤拷锟斤拷锟斤拷强锟街�锟酵匡拷锟皆革拷值
		   }
	  
	     ConsultUser byPage =new   ConsultUser();
          List<User> list =byPage.consultUser(page);
	    //  int maxpage=byPage.maxPage();
	   request.setAttribute("list",list);
	   
	   request.getRequestDispatcher("consult.jsp").forward(request,response);
			
		out.flush();
		out.close();
		}
	   
	
	@Override
	public void init() throws ServletException {
		// Put your code here
	}

}
