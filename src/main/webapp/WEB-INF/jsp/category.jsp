<%@page isELIgnored="false" %><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Category Submission</title>
</head>
<body>
<h2> Create New Category</h2>
<form:form method="POST" action="${action}">
	<form:hidden path="id"/>
   <table>
    <tr>
        <td><form:label path="name">Category Name</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
 	<tr>
 	
        <td><form:label path="parent">Parent</form:label></td>
        <td>
        	<form:select path="parent">
	        	<form:option value="-1" label="--- Select ---"/>
	    		<form:options items="${categories}" itemValue="id" itemLabel="name" />
			</form:select>
		</td>
    </tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
    
</table>  
</form:form> 
</body>
</html>