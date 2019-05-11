<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<div class="login-form" >
		<h3>Please sign in</h3>
		<hr>   
		<form:form action="adminLogin" method="POST" id="login-form" modelAttribute="admin">
		    <div class="form-group">
		      <input type="text" class="form-control" id="userName" name="userName" placeholder="User Name" checked="checked">
		    </div>
		    <div class="form-group">
		      <input type="password" class="form-control" id="password" name="password" placeholder="Password" checked="checked">
		    </div>
			<br>
		    <button type="submit" class="btn btn-primary btn-block btn-success">LOG IN</button>
		    <br>
		    <h6>${message }</h6>
		 </form:form>
	</div>
</body>
</html>