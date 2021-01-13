<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${product.name }"/> Page</title>
</head>
<body>
<h1><c:out value="${product.name }"></c:out></h1>
<ul>
<c:forEach items="${proCategories}" var="category">
<li><c:out value="${category.name}"/></li>
</c:forEach>
</ul>
<form:form action="/addcategory" method="POST" modelAttribute="categories_product">
<form:input type="hidden" path="product" value="${ product.id }"/>
<form:label path="category">Add Category</form:label>
<form:errors path="category"/>
<form:select path="category">
<c:forEach items="${categories}" var="category">
<form:option value="${category.id}"><c:out value="${category.name}"/></form:option>
</c:forEach>
<input type="submit" value="Create">
</form:select>
</form:form>
</body>
</html>