<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="${page.request.contextPath }/Student_Management_System/RegistServlet" method="post">
   姓名:<input type="text" name="name">
   学号:<input type="text" name="num">
   密码:<input type="password" name="password">
   年龄:<input type="text" name="age">
   <input type="submit" value="注册">
</form>
</body>
</html>