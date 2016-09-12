package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.article.AddArticle;
import com.user.UserArticle;

public class AddArticleServlet extends HttpServlet {
	 private static final long serialVersionUID=1L;		
	/**
	 * Constructor of the object.
	 */
	public AddArticleServlet() {
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
		String title=request.getParameter("title");
		String content=request.getParameter("article_content");
		String user=request.getParameter("user");
		boolean flag=false;
		UserArticle userarticle=new UserArticle();
		userarticle.setTitle(title);
		userarticle.setContent(content);
		userarticle.setUser(user);
		
		AddArticle addarticle=new AddArticle();
		int i= addarticle.addarticle(userarticle);
		try{
			if(i>0){
				//System.out.println("文章存储成功");
				flag=true;
				//response.sendRedirect("index.html");
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
