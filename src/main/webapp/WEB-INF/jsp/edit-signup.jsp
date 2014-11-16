<%@page isELIgnored="false" %><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recipe User SignUp</title>
</head>
<body>
<h2>Edit User Information</h2>
<form:form method="POST" action="${action}">
	<form:hidden path="id"/>
   <table>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" /><form:errors path="name"></form:errors></td>
    </tr>
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
</body>
</html>