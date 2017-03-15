<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>

</head>


<script type="text/javascript">

</script>
<body>

	<form name="userlogin" action="${pageContext.request.contextPath}/login.action"
		method="post">
		<table border="1" width="50%" align="center">

			<tr align="center">
				<td>用户名:<input type="text" name="userCustom.username" /></td>
				 
			</tr>
			<tr align="center">

				<td>密码：<input type="text" name="userCustom.password" /></td>
			</tr>
			<tr align="center">

				<td><input type="submit" value="登录" />
			<a href="${pageContext.request.contextPath}/user_register1.jsp">注册</a>
				</td>
				
			</tr>
			<tr align="center">

				<td><font color="red">${msg }</font></td>
			</tr>

		</table>
	</form>
</body>
</html>