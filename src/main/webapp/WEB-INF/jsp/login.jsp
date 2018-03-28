<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<%@ include file="/WEB-INF/inc/defaults.inc"%>
<script type="text/javascript">
$('#user_login').form({
	success:function(data){
		$.messager.alert('Info', data, 'info');
	}
});
</script>

</head>
<body>

	<div style="padding: 3px 2px; border-bottom: 1px solid #ccc">登录</div>
	<form id="user_login" action="<%=basePath%>user/login.go" method="post">
		<table>
			<tr>
				<td>账号:</td>
				<td><input name="name" type="text"></input></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input name="email" type="text"></input></td>
			</tr>
			<tr>
				<td>保存密码:</td>
				<td><input name="rememberMe" type="checkbox"></input></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="登录"></input></td>
			</tr>
		</table>
	</form>

	<button
		onclick="window.location.href='<%=basePath%>/user/register/toRegister.go'">注册</button>
</body>
</html>