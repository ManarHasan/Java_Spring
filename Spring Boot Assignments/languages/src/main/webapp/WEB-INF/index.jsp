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
<h1>All Languages</h1>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Current Version</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${languages}" var="language">
        <tr>
            <td><c:out value="${language.name}"/></td>
            <td><c:out value="${language.creator}"/></td>
            <td><c:out value="${language.currentVersion}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/languages/new">New Book</a>
</body>
</html>