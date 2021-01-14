<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Dashboard</title>
</head>
<body>
<table>
<thead>
<tr>
<th>Question</th>
<th>Tag</th>
</tr>
</thead>
<c:forEach items="${questions}" var="question">
<tr>
<td><a href="/question-profile/${question.id}"><c:out value="${question.question}"/></a></td>
<td><c:forEach items="${question.tags}" var="tag"><c:out value="${tag.subject}"/> </c:forEach> </td>
</tr>
</c:forEach>
</table>
</body>
</html>