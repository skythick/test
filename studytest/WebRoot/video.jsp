<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'video.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
 <%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"; 
 %>
  <body>
  <h1>测试播放视频</h1>
  <h2><%=basePath %></h2>
 
  <h3></h3>
  <!-- 
<embed src="localhost:8080/video/plays/test01.avi">
 -->
<video width="320" height="240" controls="controls">
  <source src="http://localhost:8080/video/plays/test02.mp4" type="video/mp4">
Your browser does not support the video tag.
</video>
  </body>
</html>
