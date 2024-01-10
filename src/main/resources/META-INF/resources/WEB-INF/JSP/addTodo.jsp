<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<%@ include file="JSPF/navigation.jspf" %>	
	<form:form method="post" modelAttribute="myTodo">
	
	
<style>
fieldset{
	border:0px
}
</style>
	
	<div class="container">
	<fieldset class="mb-2">
	<form:label path="whatToDo">
	Description: <form:input type="text" path="whatToDo"/>
	<form:errors cssClass="text-warning" path="whatToDo"/>
	</form:label>
	</fieldset>
	
	
	
	<fieldset>
	<form:label path="date">
	LocalDate: <form:input type="text"  path="date"/>
	<form:errors cssClass="text-warning" path="date"/>
	</form:label>
	</fieldset>
	
	
	<input type="submit"/><br>
	</div>
	
	</form:form>
	
	<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
		<script src="/webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>
	
<script type="text/javascript">
$('#date').datepicker({
    format: 'yyyy-mm-dd',
    startDate: '-3d'
});



</script>
	
	

</body>
</html>