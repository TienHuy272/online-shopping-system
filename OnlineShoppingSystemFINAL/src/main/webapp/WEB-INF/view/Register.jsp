<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<div class="register-form" >
		<h3>Please Register</h3>
		<hr>   
		<form:form action="customerRegister" method="POST" id="register-form" modelAttribute="customer">
		    <div class="form-group">
		      <input type="text" class="form-control" id="userName" name="userName" placeholder="User Name" checked="checked">
		    </div>
		    <div class="form-group">
		      <input type="password" class="form-control" id="password" name="password" placeholder="Password" checked="checked">
		    </div>
		    <div class="form-group">
		      <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name" checked="checked">
		    </div>
		    <div class="form-group">
		      <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name" checked="checked">
		    </div>
		    <div class="form-group">
		      <input type="text" class="form-control" id="phone" name="phone" placeholder="Phone" checked="checked">
		    </div>
			<br>
		    <button type="submit" class="btn btn-primary btn-block btn-success">REGISTER</button>
		    <br>
		    <a href="customerLogin">Click return Login</a>
		</form:form>
	</div>
</body>
</html>