<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<style>
a{
text-decoration:none !important;
}
.btn-primary{
padding: 5px 10px;
border-radius: 10px;
}
</style>
</head>
<body>
<h1 class="display-1">You have entered the prison of Nablus you need to run!!</h1>
<h3 class="display-4">You owe them <%= (int)session.getAttribute("gold")*-1%> gold try again!</h3>
<div class="type col-lg-2 col-md-1">
<h3>Casino!</h3>
<p>(earns/takes 0-50 gold)</p>
<form action="submit" method=post>
<input type="hidden" name="type" value="casino">
<input class="btn-primary" type="submit" value="Find Gold!">
</form>
</div>
<h3 class="display-4">Or reset..</h3>
<a class="btn-primary" href="/reset">Restart!</a>
</body>
</html>