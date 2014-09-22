<%@page isELIgnored="false" %><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Recipe Form</title>
</head>
<body>
<h2>Submit New Recipe -${userdisplay.name} </h2>
<form:form method="POST" action="${action}">
	<form:hidden path="idrecipe"/>
   <table>
    <tr>
        <td><form:label path="title">Title</form:label></td>
        <td><form:input path="title" /> <form:errors path="title" cssclass="error"></form:errors></td>
    </tr>
    <tr>
        <td><form:label path="displaymsg">Display Message</form:label></td>
        <td><form:input path="displaymsg" /><form:errors path="displaymsg"></form:errors></td>
    </tr>
    <tr>
        <td><form:label path="instruction">Instruction</form:label></td>
        <td><form:input path="instruction" /></td>
    </tr>
     <tr>
        <td><form:label path="cookingtime">Cooking Time</form:label></td>
        <td><form:input path="cookingtime" /></td>
    </tr>
    <tr>
        <td><form:label path="cookingcategory">Cooking Category</form:label></td>
        <td>
        	<form:select path="cookingcategory">
        		<form:options items="${categorylist}" itemValue="id" itemLabel="name" />
        	</form:select>
        </td>
    </tr>
    <tr>
        <td><form:label path="cuisine">Cuisine</form:label></td>
        <td><form:input path="cuisine" /></td>
    </tr>
    <tr>
        <td><form:label path="ingredients">Ingredients</form:label></td>
        <td><form:input path="ingredients" /></td>
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