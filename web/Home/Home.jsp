<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<html>
	<head>
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/Home.js"></script>
		<meta charset="UTF-8">
		<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
		<META HTTP-EQUIV="Expires" CONTENT="0">
		<link rel="stylesheet" type="text/css" href="css/ALL.css" />
		 <link rel="import" href="fotter.html" id="page2"/>
		<title>主页面</title>
	</head>
	<body background="img/background.jpg" >
		<!--/*frame和object都是相当于把整个html拉进来，如果设置原html在中间，那拉进来的时候他就一直在中间，怎么调也调不好。如果想让他和框框对齐，那就必须设置原html的元素在html左上角*/-->
		<!--/* 另外 html和body中间会有边距，就是说游览器是个大框  body在大框里面*/-->
		<div class="headcss">
			<%@include file="head.html" %>
		</div>
		
		<div class=maintable>
					<ul id="menu">
					<li id="menu-li1"><a ><span>waiting....</span></a></li>
				        <li id="menu-li2"><a ><span>waiting....</span></a></li>
				        <li id="menu-li3"><a ><span>waiting....</span></a></li>
				        <li id="menu-li4"><a ><span>waiting....</span></a></li>
				        <li id="menu-li5"><a href="File.jsp"><span>下载项</span></a></li>
			  		</ul>
		</div>
		<div class=verticalMenu>
			<table >
				<tr>
					<td >
						<a href="#" id=formtableII1>waiting....</a>
					</td>
				</tr>
				
				<tr>
					<td >
						<a href="#" id=formtableII2>waiting....</a>
					</td>
				</tr>
				
				<tr >
					
					<td >
						
						<a  href="#" id=formtableII3>waiting....</a>
					</td>
				</tr>
				
			</table>
		</div>
		<div class=detail-message>
			<a id=message>详细内容</a>
		</div>
		<div class="personchooseI">
			<a >
				<%@include file="personIfor.jsp" %>
			</a>	
		</div>	
		<iframe  class=WebIforframe src="WebIfor.html" ></iframe> 
	</body>

</html>
