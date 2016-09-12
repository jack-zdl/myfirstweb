<%@ page language="java" import="java.util.*"  pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>欢迎来到国泰君安商城</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="content-type" content="text/html; charset=utf-8"> 
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  
    <script src="JS/jquery.js" type="text/javascript"></script>
    <script src="JS/new.js" type="text/javascript">
    </script>
    
  </head>
  
  <body>
  <h1><strong>欢迎来到修改页面</strong></h1><br><br>
  <p></p>
  <form  action="UpdateUserServlet.java"  method="post">
  <table border="1">
  <tr><th>ID</th><th> 名字 </th><th> 密码 </th><th>性别</th><th>年龄</th><th>生日</th><th>操作</th></tr>
  <c:forEach items="${list}" var="user">
  <tr>
   <td> <input type="text"name="USERID" value="${user.USERID }" /></td>
   <td> <input type="text" name="USERNAME" value="${user.USERNAME}" /></td>
    <td><input  type="text" name="PASSWORD"  value="${user.PASSWORD}" /></td>
    <td><input type="text" name="SEX" value="${user.SEX}" /></td>
     <td><input type="text" name="AGE" value="${user.AGE}" /></td>
      <td><input type="text" name="BIRTHDAY" value="${user.BIRTHDAY}" /></td>
       
<!--<td> <button> type="button" name="ADDTIME" value="${user.ADDTIME}" </button></td>  -->
    <td> 
   
  
    </td> 
    </tr>
    </c:forEach>
      </table>
      <input type="submit" name="提交"/>
 </form>
 <p>你的ID不用修改</p>
 <p><strong>请修改你的信息</strong></p>
 <a href="index.html"><button>返回页面</button></a>
  </body>
  </html>
  