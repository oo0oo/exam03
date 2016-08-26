<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<style type="text/css">
body {
	color: #000;
	font-size: 24px;
	margin: 20px auto;
}
</style>
<%-- 
<script type="text/javascript">
	function check(form) {
		if (document.forms.loginForm.uname.value == "") {
			alert("请输入用户名");
			document.forms.loginForm.uname.focus();
			return false;
		}
	
		
	}
</script>
--%>
</head>
<body>
	<form action="<%=request.getContextPath()%>/addservlet" method="post" name="addForm">
		
		<table border="1" cellspacing="0" cellpadding="5" bordercolor="silver"
			align="center">
			<tr>
				<td colspan="2" align="center" bgcolor="#E8E8E8">新增电影</td>
			</tr>
			<tr>
				<td>电影名称：</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td>电影描述：</td>
				<td><input type="text" name="discription" /></td>
			</tr>
			<tr>
				<td>电影语种：</td>
				<td><input type="text" name="language" /></td>
			</tr>
		
			<tr>
				<td colspan="2" align="center">
				<input type="submit" name="submit" onclick="return check(this);" />
				<input type="reset" name="reset" />
		</table>
	</form>
</body>
</html>

