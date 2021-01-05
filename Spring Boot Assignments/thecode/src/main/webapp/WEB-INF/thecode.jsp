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
<form method="POST" action="/code">
<label>What is the code</label>
<input type="text" name="code" placeholder="Try code">
<input type="submit" value="Try code">
<c:out value="${error}"/>
</form>
</body>
</html>