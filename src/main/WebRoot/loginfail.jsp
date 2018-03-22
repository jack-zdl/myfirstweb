<%@ page language="java" import="java.util.*"  pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script src="JS/jquery.js"></script>

  <title>
  登陆失败页面
  </title>
  <body>
  <h1>登陆失败</h1>
   <a href="index.html"><button>登陆失败</button></a>
  </body>
  </head>
 