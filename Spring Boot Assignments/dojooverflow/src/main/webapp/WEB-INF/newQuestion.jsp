<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Question</title>
</head>
<body>
<form:form action="/question/add" method="post" modelAttribute="custom_valid">
	
	<form:label path="questionText">Question: </form:label>
	<form:errors path="questionText"/>
	<form:input path="questionText"/>
	
	<form:label path="subject">Tags: </form:label>
	<form:errors path="subject"/>
	<form:input path="subject"/>
	
	<input type="submit" value="Create">
</form:form>
</body>
</html>