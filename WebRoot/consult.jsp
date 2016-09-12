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
    $(function(){
       $("#o").click(function(){
       		alert("warming  href is worry");
       		});
    });
    
    
    </script>
    
  </head>
  
  <body>
  <h1><strong>欢迎来到查看页面，你可以查询全体成员信息</strong></h1><br><br>
  <p></p>
  <form  action=""  method="post">
  <table border="1">
  <tr><th>ID</th><th> 名字 </th><th> 密码 </th><th>性别</th><th>年龄</th><th>生日</th><th>添加时间</th><th>操作</th></tr>
  <c:forEach items="${list}" var="user">
  <tr>
   <td> <c:out value="${user.USERID }" /></td>
   <td> <c:out value="${user.USERNAME}" /></td>
    <td><c:out  value="${user.PASSWORD}" /></td>
    <td> <c:out value="${user.SEX}" /></td>
     <td> <c:out value="${user.AGE}" /></td>
      <td> <c:out value="${user.BIRTHDAY}" /></td>
       <td> <c:out value="${user.ADDTIME}" /></td>
    <td> 
     <a  id="o" href="ModificationUserServlet.no?id=${user.USERID }">修改</a>
     <a href="DeleteUserServlet.go?id=${ user.USERID}">删除</a>
    </td> 
    </tr>
    </c:forEach>
      </table>
 </form>
 
 <!-- 
  <form  action="ModificationUserServlet.no"  method="post">
         <input type="submit" value="点击">
  </form> 
  -->
 <a href="index.html"><button>返回页面</button></a>
  </body>
  </html>
  