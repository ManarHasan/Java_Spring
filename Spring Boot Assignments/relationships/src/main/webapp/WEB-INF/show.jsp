<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body>
<div>
<h3>First Name  :<c:out value="${person.firstName}"/></h3>
<h3>Last Name  :<c:out value="${person.lastName}"/></h3>
<h3>Number  :<c:out value="${person.license.number}"/></h3>
<h3>State  :<c:out value="${person.license.state}"/></h3>
<h3>Expiration Date  :<c:out value="${person.license.expirationDate}"/></h3>
</div>

</body>
</html>
