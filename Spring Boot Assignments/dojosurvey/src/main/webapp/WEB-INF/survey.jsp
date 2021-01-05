<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/submit" method="post">
<label for="name">Your Name: </label>
<input type="text" name="name" placeholder="Fill your name here">
<label for="location">Dojo Location: </label>
<select name="location">
<option value="Ramallah">Ramallah</option>
<option value="Bethlehem">Bethlehem</option>
<option value="New York">New York</option>
</select>
<label for="language">Favorite Language: </label>
<select name="language">
<option value="Python">Python</option>
<option value="Java">Java</option>
<option value="REACT">REACT</option>
</select>
<label for="comment">Comment (optional): </label>
<textarea name="comment" placeholder="Write your comment here"></textarea>
<input type="submit" value="Submit">
</form>
</body>
</html>