<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="./css/demo.css" type="text/css">
	<link rel="stylesheet" href="./css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="./js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="./js/jquery.ztree.core.js"></script>
<script type="text/javascript">
var setting = {
		view: {
			showIcon: showIconForTree
		},
		data: {
			simpleData: {
				enable: true
			}
		}
	};
	//var text = ${typejson};
	//var zNodes =eval("(" + text + ")");
	var arr = ${typelist};
	alert(arr.length);
	var nodearr = [arr.length];
	for ( var i = 0; i < arr.length; i++) {
		var type = arr[i];
		node = "{ id:"+type.tid+", pId:"+type.parentid+", name:\""+type.typename+"\"},";
		nodearr[i] =node; 
	}
	var zNodes = nodearr;
	//var zNodes =${typejson};

 		function showIconForTree(treeId, treeNode) {
 			return !treeNode.isParent;
 		};

 		$(document).ready(function(){
 			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
 		});
</script>
  </head>
  
  <body>
	<div>
		<ul id="treeDemo" class="ztree"></ul>
	</div>
  </body>
</html>
