<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册用户</title>
</head>
<body>

	<form action="<%=basePath%>user/register.go" method="post">
		昵称：<input type="text" name="username" /><br> 
		密码：<input type="password" name="password" /><br> 
		<input type="submit" value="注册" />
	</form>

</body>
</html>