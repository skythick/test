<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <!-- 它的作用是为本页面所有的表单和超链接指定显示内容的框架！ -->
    <base target="list1">
    <title>软件测试学习路线图</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
 <dl>

<c:if test="${not empty typelist}">
<c:forEach items ="${typelist }" var = "type">
<dt>${type.typename }</dt>
<c:if test="${not empty type.children}">
<c:set var="typelist" value = "${type.children }" scope="request" />
<c:import url="itemlist.jsp"></c:import>
</c:if>
</c:forEach>
 </c:if>
</dl>
 </body>
</html>
