<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="JSPF/navigation.jspf" %>	
</head>
<body>
	<form method="post">
	Name: <input type="text" required="required" name="name"/>
	Password: <input type="password" name="password" required="required"/>
	<input type="submit"/>
	</form>
		<pre> ${Error}</pre>
</body>
</html>