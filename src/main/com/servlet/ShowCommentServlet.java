package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.connection.Conn;
import com.show.ShowComment;


public class ShowCommentServlet extends HttpServlet {
	 private static final long serialVersionUID=1L;
	/**
	 * Constructor of the object.
	 */
	public ShowCommentServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	@Override
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
	@Override
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
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
			 String titleid=request.getParameter("titleid");
		//	String pagee=request.getParameter("page1");
			 Integer pageCount; 
				if(request.getParameter("page1") != null){
					 pageCount = Integer.parseInt(request.getParameter("page1"));
				}else{
					pageCount=1;
				}
				
			 JSONArray ja = new JSONArray();
			//JSONObject jb = new JSONObject();
			 ShowComment sc=new ShowComment();
			 Connection con= null;
				PreparedStatement ps= null;
				ResultSet rs=null;
				int pageSize = 3;//每页显示几条
				int totle = this.getCount(titleid);//总条数
				
				int pageTotle = 0;//总页数
				if(totle%pageSize==0){
					pageTotle=totle/pageSize;
				}else{
					pageTotle=totle/pageSize+1;
				}
				if(pageCount >= pageTotle){
					pageCount = pageTotle;
				}
				int limit2 = (pageCount -1) * pageSize;//当前页显示条数
				if(limit2 <= 0){
					limit2=0;
				}
				//set limit=limit ; 
			 try {
				 con=Conn.getConnection();
					String sql="SELECT  top 3 titleid,username,comment_content,addtime  FROM comment  where id not in (SELECT  top " + limit2+" id  FROM comment where titleid="+ titleid+") and titleid="+ titleid+" ";
					ps=con.prepareStatement(sql);
					//ps.setString(1,titleid);
					rs=ps.executeQuery();
					ResultSetMetaData metadata = rs.getMetaData();
					int column = metadata.getColumnCount();//hang数
					while(rs.next()){
						JSONObject jb = new JSONObject();
						for(int i=1;i<=column;i++){
							String columnName=metadata.getColumnLabel(i);//返回列名
							String value=rs.getString(columnName);//
							jb.put(columnName, value);
						}
						jb.put("pageTotle", pageTotle);
						ja.add(jb);
					}
				String jas = sc.commentToJson();
				//System.out.println("JSON格式1--"+jas);
				ja.fromObject(jas);
				System.out.println("JSON格式2--"+jas);
				  out.print(ja);
			 
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
	public int getCount(String titleid){
		int i=0;
		Connection con= null;
		PreparedStatement ps= null;
		con=Conn.getConnection();
		String sql="select count(*) as count from comment WHERE titleid='" +titleid+ "'";
		ResultSet rs=null;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				i=rs.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	@Override
	public void init() throws ServletException {
		// Put your code here
	}

}
