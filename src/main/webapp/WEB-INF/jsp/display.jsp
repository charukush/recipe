<%@page isELIgnored="false" %><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recipe SignIn</title>
<link rel="stylesheet" type="text/css" href="/recipe/css/style.css">
</head>
<body>
<div id="container">
	<div id="header">
		<h1>
			Site name
		</h1>
	</div>
	<div id="navigation">
		<ul>
			<li><a href="/recipe/charu/user/index">HOME</a></li>
			<li><a href="#">ABOUT</a></li>
			<li><a href="/recipe/charu/recipe/AllRecipes">RECIPES</a></li>
			<li><a href="#">BLOG</a></li>
			<li><a href="/recipe/charu/user/SignIn">LOGIN</a></li>
			<li><a href="/recipe/charu/user/new">REGISTRATION</a></li>
			<li><a href="/recipe/charu/user/myaccount">GO TO MYACCOUNT</a></li>
		</ul>
	</div>
	<div id="content-container">
	
		<div id="content">
			<h2>
				Display All Recipies
			</h2>

		<c:forEach var="recipe" items="${recipes}">
			${recipe.title} <br/> ${recipe.displaymsg}<br/> 
			${recipe.instruction}<br/>${recipe.cookingtime}<br/>
			${recipe.cookingcategory}<br/>${recipe.cuisine}<br/>
			${recipe.ingredients}<br/><hr/>
		</c:forEach>
		</div>

		<div id="aside">

		</div>
		<div id="footer">
			Copyright © Site name, 20XX
		</div>
	</div>
</div>
</body>
</html>