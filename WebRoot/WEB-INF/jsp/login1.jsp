<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>异常页面</title>
</head>
<body>
<center>
<form action="${pageContext.request.contextPath}/login.action "method="post">
用户名:<input type="text" name="userCustom.username"/><br>
密码：<input type="text" name="userCustom.password"/><br>
<input type="submit" value="登录"/><br>
<font color="red">${msg }</font>
</form>
</center>
</body>
</html>