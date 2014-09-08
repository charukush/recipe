<%@page isELIgnored="false" %><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display All Recipe</title>
</head>
<body>
<c:forEach var="recipe" items="${recipes}">
	${recipe.title} <br/> ${recipe.displaymsg}<br/> 
	${recipe.instruction}<br/>${recipe.cookingtime}<br/>
	${recipe.cookingcategory}<br/>${recipe.cuisine}<br/>
	${recipe.ingredients}<br/><hr/>
</c:forEach>
</body>
</html>