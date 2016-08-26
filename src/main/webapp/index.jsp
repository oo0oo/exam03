<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	首页<br/>
	<br/>
	<a href="<%=request.getContextPath()%>/add.jsp">新增电影</a><br/><br/>
	<a href="<%=request.getContextPath()%>/displayservlet">显示电影</a><br/><br/>
	<a href="<%=request.getContextPath()%>/delete.jsp">删除电影</a><br/><br/>
	<%
		String flag = "";
		Object obj = session.getAttribute("flag");
		if(obj!= null){
			flag = obj.toString();
		}
		if(flag.equals("login_success")){			
				
	%>
	<a href="<%=request.getContextPath()%>/logoutservlet">退出</a>
	<%}else {%>
		<a href="<%=request.getContextPath()%>/login.jsp">登录</a>
	<%} %>
</body>
</html>