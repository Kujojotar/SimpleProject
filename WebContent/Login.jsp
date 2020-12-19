<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="${page.request.contextPath }/Student_Management_System/LoginServlet" method="post">
   学号:<input type="text" name="num">
   密码:<input type="password" name="password">
   <input type="submit" value="登录">
</form>
<br />
<a href="${page.request.contextPath }/Student_Management_System/RegisterServlet">点这里注册</a>
</body>
</html>