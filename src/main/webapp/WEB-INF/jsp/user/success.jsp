<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录注册成功</title>
</head>
<body>
<h1>登录注册成功</h1>
	<shiro:user>  
		欢迎[<shiro:principal/>]登录，退出<br/> 
	</shiro:user>
	
	<shiro:hasRole name="admin">  
	    用户[<shiro:principal/>]拥有角色admin<br/>  
	</shiro:hasRole> 
	<shiro:hasRole name="qweasd">  
	    用户[<shiro:principal/>]拥有角色qweasd<br/>  
	</shiro:hasRole> 
	<shiro:hasPermission name="add">  
 	   用户[<shiro:principal/>]拥有权限add<br/>  
	</shiro:hasPermission>      
</body>
</html>