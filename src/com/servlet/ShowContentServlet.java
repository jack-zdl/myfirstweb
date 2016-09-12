package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.modification.ModificationUser;
import com.show.ShowContent;
import com.user.User;
import com.user.UserArticle;

public class ShowContentServlet extends HttpServlet {
	 private static final long serialVersionUID=1L;
	/**
	 * Constructor of the object.
	 */
	public ShowContentServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		this.doPost(request, response);
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
	@SuppressWarnings("static-access")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
	
//		  String page1=request.getParameter("page");  //锟斤拷锟揭筹拷娲拷锟斤拷锟斤拷锟街�
//		   int page=1;
//		   if(page1 !=null){
//			   page=Integer.parseInt(page1);  //锟斤拷锟揭筹拷娲拷锟斤拷锟斤拷锟斤拷强锟街�锟酵匡拷锟皆革拷值
//			   }
		JSONArray ja = new JSONArray();
		//JSONObject jb = new JSONObject();
		 ShowContent sc=new ShowContent();
		 try {
			String jas = sc.resultToJson();
			//System.out.println("JSON格式1--"+jas);
			ja.fromObject(jas);
			//System.out.println("JSON格式2--"+jas);
			out.print(jas);
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   //request.getRequestDispatcher("index.html").forward(request,response);
	
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
