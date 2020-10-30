<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,pojo.User"%>
<html>
	<head>
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/File.css" />
		
		
		<meta charset="UTF-8">
		<title>文档界面</title>
	</head>
	<body class="FileBody">
		<div class="headcss">
			<%@include file="head.html"%>
		</div>
		
		<div class="File-tile">
			
		</div>
		
		<div class="File-dictory">
			<div class="File-dictoryi">
				<div class="File-dictoryi-" id="File-dictoryi-return">上一页</div>
				<div  class="File-dictoryi-" id="File-dictoryi-middle">主页</div>
				<div  class="File-dictoryi-" id="File-dictoryi-forward">下一页</div>
		    </div>
			<div class="File-dictoryii">
				<ul id="FileName" >
					<!--<li><input type=\"radio\" ><a><span>"+fileName+"</span></a>"</li>-->
				</ul>
		    </div>
	    </div>
	    <div id="SpecificFile">
	    	
	    </div>
	    
	    
	    
	    
	    
		<div class="personchoose">
			<a>
				<%@include file="personIfor.jsp" %>
			</a>	
		</div>	
		<div id="Specific_performoce">
				
		</div>	
	
	</body>
	
	<script type="text/javascript" src="js/File.js"></script>
</html>
