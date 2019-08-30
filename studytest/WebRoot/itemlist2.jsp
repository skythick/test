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
<script type="text/javascript" src="<c:url value='/ajax-lib/ajaxutils.js'/>"></script>
<script type="text/javascript">

function createXMLHttpRequest() {
	try {
		return new XMLHttpRequest();//大多数浏览器
	} catch (e) {
		try {
			return ActvieXObject("Msxml2.XMLHTTP");//IE6.0
		} catch (e) {
			try {
				return ActvieXObject("Microsoft.XMLHTTP");//IE5.5及更早版本	
			} catch (e) {
				alert("哥们儿，您用的是什么浏览器啊？");
				throw e;
			}
		}
	}
}
function showtype(id){
	alert(id);
	/*
	1. ajax
	*/
	/*
	ajax四步操作，得到服务器的响应
	把响应结果显示到h1元素中
	*/
	/*
	1. 得到异步对象 
	*/
	var xmlHttp = createXMLHttpRequest();
	/*
	2. 打开与服务器的连接
	  * 指定请求方式
	  * 指定请求的URL
	  * 指定是否为异步请求
	*/
	/************修改open方法，指定请求方式为POST**************/
	xmlHttp.open("POSt", "<c:url value='/TypeServlet'/>", true);
	/************设置请求头：Content-Type************/
	xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	/*
	3. 发送请求
	*/
	/**********发送时指定请求体***********/
	xmlHttp.send("method=findById&parentid="+id);
	
	xmlHttp.onreadystatechange = function() {
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {
			var ddtype = document.getElementById("child"+id);
			var ddEleList = ddtype.getElementsByTagName("dd");
			
			// 循环遍历每个option元素，然后在citySelect中移除
			while(ddEleList.length > 0) {//子元素的个数如果大于1就循环，等于1就不循环了！
				citySelect.removeChild(ddEleList[0]);//总是删除1下标，因为1删除了，2就变成1了！
			}
			// 获取服务器的响应结束
			var text = xmlHttp.responseText;
			alert(text);
			var data = eval("(" + text + ")");
			for (var i = 0; i < data.length; i++){
				var typeEle = data[i];//得到每个city元素
				var childName = typeEle.typename;
				/*
				*/
				var op =document.createElement("dd");
				var typeid = typeEle.tid ;
				op.id = typeid;
				op.setAttribute("onclick","showtype(this.id)");
				var textNode = document.createTextNode(childName);
				op.appendChild(textNode);//把文本节点追加到op元素中
				ddtype.appendChild(op);
				var childiv = document.createElement("div");
				childiv.id = "child"+typeEle.tid;
				childiv.setAttribute("style","white-space:nowrap");
				ddtype.appendChild(childiv);
			}
		}
	};
}
</script>

  </head>
  
  <body>
 <dl>


<c:forEach items ="${requestScope.typelist }" var = "type">
<dt id = "${type.tid }" onclick="showtype(this.id)">${type.typename }</dt>
<div id = "child${type.tid }">

</div>
</c:forEach>
</dl>
 </body>
</html>
