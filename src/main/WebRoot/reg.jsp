<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
   
    <script src="JS/jquery.js" type="text/javascript"></script>
    <script src="JS/new.js" type="text/javascript">
   
    </script>
    <title>欢迎来到国泰君安商城</title>
   
	
	
  </head>
  
  <body>
  <h1><strong>欢迎来到国泰君安，请你登陆</strong></h1><br><br>
  <form  name="form1" action="AddUserServletServlet.do" method="post">
 
 	 姓名
 	 
  	<input type="text" name="USERNAME">
  
  <br>
  <br>

密码
<input type="text" name="PASSWORD">
 
 <br><br>
 
<input type="submit" value="注册" id="signUp">
  
  </form><br>
  </body>
</html>
  