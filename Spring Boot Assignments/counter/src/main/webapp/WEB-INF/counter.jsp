<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
You visited the home page <c:out value="${sessionScope.count }"></c:out> times.
<a href="/">Go try again!</a>
<a href="/times-two">Add Two!</a>
<a href="/delete">Delete</a>
</body>
</html>