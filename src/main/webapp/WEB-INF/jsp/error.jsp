<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/static/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>WEB-INFO/error</title>
		 
		 </head>
<body>
<div class="well">
	<h1 class="grey lighter smaller">
		<span class="blue bigger-125"><i class="icon-sitemap"></i> <%=request.getAttribute("javax.servlet.error.status_code")%></span> 没有找到此页面
	</h1>
	<hr />
	<h3 class="lighter smaller">We looked everywhere but we couldn't find it!</h3>
	
	<div>
		
		<div class="space"></div>
		
		<h4 class="smaller">Try one of the following:</h4>
		<ul class="unstyled spaced inline bigger-110">
			<li><i class="icon-hand-right blue"></i> 检查路径是不是有误</li>
			<li><i class="icon-hand-right blue"></i> 检查代码是不是有误</li>
			<li><i class="icon-hand-right blue"></i> 检查环境配置是不是有误</li>
			
			<li><i class="icon-hand-right blue"></i>信息： <%=request.getAttribute("javax.servlet.error.message")%></li>
			<li><i class="icon-hand-right blue"></i>异常： <%=request.getAttribute("javax.servlet.error.exception_type")%></li>
		</ul>
	</div>
	
	<hr />
	<div class="space"></div>
	
	<div class="row-fluid">
		<div id="zhongxin">
		</div>
	</div>
</div>
	</body>
</html>