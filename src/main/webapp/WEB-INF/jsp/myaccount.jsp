<%@page isELIgnored="false" %><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
			<li><a href="/recipe/charu/user/update-${user.id}">UPDATE MY DETAILS</a></li>
			<li><A href="/recipe/charu/recipe/newrecipe">ADD NEW RECIPE</A></li>
			<li><a href="/recipe/charu/user/logout">LOGOUT</a></li>
		</ul>
	</div>
	<div id="content-container">
		<div id="content">
			<h2>
				Page heading
			</h2>
         My Account > Welcome ${user.name}
<hr>

<p>

My Recipes   <p>
<c:forEach var="recipe" items="${recipes}">
	${recipe.title} - ${recipe.displaymsg}(${recipe.cookingcategory.name}) [<A href="/recipe/charu/recipe/update-${recipe.idrecipe}">Edit</A> | <A href="/recipe/charu/recipe/delete-${recipe.idrecipe}">Delete</A>]<br/>
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