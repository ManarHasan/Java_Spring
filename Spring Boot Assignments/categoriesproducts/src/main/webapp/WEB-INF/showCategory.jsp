<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${category.name }"/> Page</title>
</head>
<body>
<h1><c:out value="${category.name }"></c:out></h1>
<ul>
<c:forEach items="${catProducts}" var="product">
<li><c:out value="${product.name}"/></li>
</c:forEach>
</ul>
<form:form action="/addproduct" method="POST" modelAttribute="categories_product">
<form:input type="hidden" path="category" value="${ category.id }"/>
<form:label path="product">Add Product</form:label>
<form:errors path="product"/>
<form:select path="product">
<c:forEach items="${products}" var="product">
<form:option value="${product.id}"><c:out value="${product.name}"/></form:option>
</c:forEach>
<input type="submit" value="Create">
</form:select>
</form:form>
</body>
</html>