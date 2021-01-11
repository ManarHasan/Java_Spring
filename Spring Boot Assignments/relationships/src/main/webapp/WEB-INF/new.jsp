<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New License</title>
</head>
<body>
<h1>New License</h1>
<form:form action="/licenses" method="post" modelAttribute="licenses">
    <p>
        <form:label path="person">Person</form:label>
        <form:errors path="person"/>
        <form:select path="person">
        <c:forEach  items="${persons}" var="person">
        	<form:option value="${person.id}"><p><c:out value="${person.firstName}"></c:out> <c:out value="${person.lastName}"></c:out></p></form:option>
        </c:forEach>
       </form:select>
    </p>
    <p>
    	<form:label path="state">State</form:label>
    	<form:errors path="state"/>
    	<form:input path="state"/>
    </p>
    <p>
    	<form:label path="expirationDate">Expiration Date</form:label>
    	<form:errors path="expirationDate"/>
    	<form:input type="date" path="expirationDate"/>
    </p>
    

    <input type="submit" value="Create"/>
</form:form>

</body>
</html>
