<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Category</title>
</head>
<body>
<form:form action="/category" method="post" modelAttribute="category">
	
	<form:label path="name">Name: </form:label>
	<form:errors path="name"/>
	<form:input path="name"/>
	
	<input type="submit" value="Create">
</form:form>
</body>
</html>