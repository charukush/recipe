<%@page isELIgnored="false" %><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		</ul>
	</div>
	<div id="content-container">
		<div id="content">
			<h2>
				Recipe SignIn
			</h2>
         <form:form method="POST" action="login">
	
   <table>
    <tr>
        <td><form:label path="email">E-mail</form:label></td>
        <td><form:input path="email" /><form:errors path="email"></form:errors></td>
    </tr>
    <tr>
        <td><form:label path="password">Password</form:label></td>
        <td><form:password path="password" /><form:errors path="password"></form:errors></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>

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