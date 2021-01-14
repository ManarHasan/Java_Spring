<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Profile</title>
</head>
<body>
<h1><c:out value="${question.question}"/></h1>
<h2>Tags: </h2>
<c:forEach items="${question.tags}" var="tag">
<button><c:out value="${tag.subject}"/></button>
</c:forEach>

<table>
<thead>
<tr>
<th>Answers</th>
</tr>
</thead>
<tbody>
<c:forEach items="${question.answers}" var="answer">
<tr>
<td><c:out value="${answer.answerr}"/></td>
</tr>
</c:forEach>
</tbody>
</table>
<form:form action="/answers/${question.id}/add" method="post" modelAttribute="answer">
	
	<form:label path="answerr">Answer: </form:label>
	<form:errors path="answerr"/>
	<form:input path="answerr"/>
	
	<input type="submit" value="Create">
</form:form>
</body>
</html>