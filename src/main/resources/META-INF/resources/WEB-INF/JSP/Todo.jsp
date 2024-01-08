<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       
<!DOCTYPE html>
<html>
<head>
<link href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css" rel="stylesheet"></link>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h1>Welcome ${name}</h1>
	Your todos are 
	<table class="table">
		<thead>
			<tr>
				
				<th>Name</th>
				<th>WhatToDo</th>
				<th>Date</th>
				<th>Done</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${todos}" var="TodoClass">
			<tr>
				
				<td>${TodoClass.name}</td>
				<td>${TodoClass.whatToDo}</td>
				<td>${TodoClass.date}</td>
				<td>${TodoClass.done}</td>
				<td><a href="/delete-todo?id=${TodoClass.id}" class="btn btn-danger">Delete</a></td>
				<td><a href="/update-todo?id=${TodoClass.id}" class="btn btn-success">Update</a></td>
			</tr>
		</c:forEach>
		</tbody>
	
	</table>
	<a href="/addNewTodo"> <div class="btn btn-success">Add Todo</div></a>
	</div>
	<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="/webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>
	
	
	
</body>
</html>