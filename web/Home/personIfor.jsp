
<%@page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,pojo.User"%>

	<head>
	
		
		<title>个人界面</title>
		
		<style>
	
			.imgig {
				border:1px solid black;
				cursor:pointer;/*鼠标样式*/
				margin: 0px;
				position: absolute;
				right：10%;

				margin: 0px;
				padding:0px;
				width: 60%;
				height:100%;
			}
			.personjpg{
			background-color: yellow;
				cursor:pointer;/*鼠标样式*/
				display:inline-block;
				width: 50%;
				height:100%;
			}
			#name{
			background-color: red;
				display:inline-block;
				border:1px solid red;
				position: absolute;
				top:0%;
				width: 100%;
				height:100%;
			}
			
			
		</style>
		<script>
			$(document).ready(function(){
				 $(".imgig").click(function(){
					 alert($("#name").text());
				 });
			});
		</script>
	</head>
	
	<body>
		<div class="imgig">		
				<img class="personjpg"src="img/person.jpg">
			<%
				User user=(User)session.getAttribute("user");
				String name=user.getName();
			%>
			<a id="name">
				<span id="namespan"><%=name%></span>
			</a>	
			
		</div>
	</body>
</html>
