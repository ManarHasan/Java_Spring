<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="/ninja" method="post" modelAttribute="ninja">
	<form:label path="dojo">Dojo: </form:label>
	<form:errors path="dojo"/>
	<form:select path="dojo">
	<c:forEach  items="${dojos}" var="dojo">
		<form:option value="${dojo.id}"><c:out value="${dojo.name}"></c:out></form:option>
	</c:forEach>
	<form:label path="firstName">First Name: </form:label>
	<form:errors path="firstName"/>
	<form:input path="firstName"/>
	
	<form:label path="lastName">Last Name: </form:label>
	<form:errors path="lastName"/>
	<form:input path="lastName"/>
	
	<form:label path="age">Age: </form:label>
	<form:errors path="age"/>
	<form:input type="number" path="age"/>
	
	<input type="submit" value="Create">
</form:select>
</form:form>
</body>
</html>