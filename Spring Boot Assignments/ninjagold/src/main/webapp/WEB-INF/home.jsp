<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.activity{
color:green;
}
span{
color:red;
}
a{
text-decoration:none !important;
}
.btn-primary{
padding: 5px 10px;
border-radius: 10px;
}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
<div class="gold">
<p>Your gold: <c:out value="${gold}"/></p>
<a class="btn-primary" href="/reset">Play again!</a>
</div>
<div class="container">
<div class="row">
<div class="type col-lg-2 col-md-1">
<h3>Farm</h3>
<p>(earns 10-20 gold)</p>
<form action="submit" method=post>
<input type="hidden" name="type" value="farm">
<input class="btn-primary" type="submit" value="Find Gold!">
</form>
</div>
<div class="type col-lg-2 col-md-1">
<form action="submit" method=post>
<h3>Cave</h3>
<p>(earns 5-10 gold)</p>
<input type="hidden" name="type" value="cave">
<input class="btn-primary" type="submit" value="Find Gold!">
</form>
</div>
<div class="type col-lg-2 col-md-1">
<h3>House</h3>
<p>(earns 5-2 gold)</p>
<form action="submit" method=post>
<input type="hidden" name="type" value="house">
<input class="btn-primary" type="submit" value="Find Gold!">
</form>
</div>
<div class="type col-lg-2 col-md-1">
<h3>Casino!</h3>
<p>(earns/takes 0-50 gold)</p>
<form action="submit" method=post>
<input type="hidden" name="type" value="casino">
<input class="btn-primary" type="submit" value="Find Gold!">
</form>
</div>
<div class="type col-lg-2 col-md-1">
<h3>Spa!</h3>
<p>(takes 5-20 gold)</p>
<form action="submit" method=post>
<input type="hidden" name="type" value="spa">
<input class="btn-primary" type="submit" value="Relax!">
</form>
</div>
</div>
</div>
<h3>Activities:</h3>
<div class="activity">
<%= session.getAttribute("activity")%>
</div>
</body>
</html>