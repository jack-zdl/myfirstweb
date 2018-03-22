<%@ page language="java" import="java.util.*"  pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title> 删除页面</title>
  </head>
  <body>
  <h1>删除成功</h1>
  <form name="form3" action="Servlet.so"method="post">
  <p>你可以查询全体成员</p>
  <input type="submit" value="查询全体成员">
  </form>
  <br><br>
  <a href="index.html"><button>返回页面</button></a>
  </body>
  </html>