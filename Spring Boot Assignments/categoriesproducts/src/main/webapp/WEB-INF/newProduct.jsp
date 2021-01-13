<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
</head>
<body>
<form:form action="/product" method="post" modelAttribute="product">
	
	<form:label path="name">Name: </form:label>
	<form:errors path="name"/>
	<form:input path="name"/>
	
	<form:label path="description">Description: </form:label>
	<form:errors path="description"/>
	<form:textarea path="description"/>
	
	<form:label path="price">Price: </form:label>
	<form:errors path="price"/>
	<form:input type="number" path="price"/>
	
	<input type="submit" value="Create">
</form:form>
</body>
</html>