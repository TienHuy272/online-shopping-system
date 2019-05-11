<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Check Out</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/checkout-style.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row checkout-content">
			<div class="col-lg-9 ">
				<h4>${message }</h4>
				<h4>Enter your payment information</h4>
				<hr />
				<form:form class="checkout-Form" action="checkout" method="POST"
					modelAttribute="order">
					<div class="align-billing-form">
						<h5>Credit or Debit Card Information:</h5>
						<br /> <input type="hidden" name="customer.customerId"
							value="${theCustomer.customerId }"> <input type="hidden"
							name="customer.password" value="${theCustomer.password }">
						<input type="hidden" name="customer.userName"
							value="${theCustomer.userName }">

						<div class="form-group row">
							<label for="firstName"
								class="col-sm-2 col-form-label position-text">First Name</label>
							<div class="col-sm-10 ">
								<input type="text" value="${theCustomer.firstName }"
									class="form-control" id="customer.firstName"
									name="customer.firstName" readonly="readonly">
							</div>
						</div>

						<div class="form-group row">
							<label for="lastName"
								class="col-sm-2 col-form-label position-text">Last Name</label>
							<div class="col-sm-10 ">
								<input type="text" class="form-control" id="customer.lastName"
									name="customer.lastName" value="${theCustomer.lastName }"
									readonly="readonly">
							</div>
						</div>

						<div class="form-group row">
							<label for="cardNumber"
								class="col-sm-2 col-form-label position-text">Card
								Number</label>
							<div class="col-sm-10 ">
								<input type="text" class="form-control" id="cartNumber"
									name="cartNumber">
							</div>
						</div>

						<div class="form-group row">
							<label for="expires"
								class="col-sm-2 col-form-label position-text">Expires</label>
							<div class="col-sm-10 row">
								<div class="col-sm-6">
									<select class="form-control" id="month" name="expires">
										<c:forEach var="i" begin="1" end="12">
											<option value="${i}">${i}</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-sm-6">
									<select class="form-control" id="year" name="expires">
										<c:forEach var="i" begin="1995" end="2018">
											<option value="${i}">${i}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group row">
							<label for="secutityCode"
								class="col-sm-2 col-form-label position-text">Secutity
								Code</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="secutityCode"
									name="secutityCode">
							</div>
						</div>
						<h5>Billing Information:</h5>
						<br />

						<div class="form-group row">
							<label for="country"
								class="col-sm-2 col-form-label position-text">Country</label>
							<div class="col-sm-10">
								<select class="form-control" id="customer.country"
									name="customer.country">
									<option value="United State">United States</option>
									<option value="United Kingdom">United Kingdom</option>
								</select>

							</div>
						</div>
						<div class="form-group row">
							<label for="companyName"
								class="col-sm-2 col-form-label position-text">Company
								Name</label>
							<div class="col-sm-10 ">
								<input type="text" class="form-control"
									id="customer.companyName" name="customer.companyName"
									placeholder="Optional">
							</div>
						</div>
						<div class="form-group row">
							<label for="billingAddress"
								class="col-sm-2 col-form-label position-text">Billing
								Address</label>
							<div class="col-sm-10 ">
								<input type="text" class="form-control" id="billingAddress1"
									name="billingAddress1" placeholder="Address line 1">
								<p></p>
								<input type="text" class="form-control" id="billingAddress2"
									name="billingAddress2" placeholder="Address line 2">
							</div>
						</div>
						<div class="form-group row">
							<label for="city" class="col-sm-2 col-form-label position-text">City</label>
							<div class="col-sm-10 ">
								<input type="text" class="form-control" id="customer.city"
									name="customer.city">
							</div>
						</div>
						<div class="form-group row">
							<label for="state" class="col-sm-2 col-form-label position-text">State</label>
							<div class="col-sm-6">
								<select class="form-control" id="customer.state"
									name="customer.state">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
								</select>

							</div>
						</div>
						<div class="form-group row">
							<label for="postalCode"
								class="col-sm-2 col-form-label position-text">Postal
								Code</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="postalCode"
									name="postalCode">
							</div>
						</div>
						<div class="form-group row">
							<label for="phone" class="col-sm-2 col-form-label position-text">Phone</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="customer.phone"
									name="customer.phone" value="${theCustomer.phone }">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-2"></div>
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary">SUBMIT</button>
								<a href="homePage" class="btn btn-danger" role="button">
									CANCEL
								</a>
							</div>
						</div>
					</div>
				</form:form>
			</div>
			<div class="col-lg-3">
				<div class="checkout-content border-box">
					<c:set var="totalPrice" scope="page" value="0" />
					<c:forEach var="entry" items="${listOrderProduct}">

						<c:set var="totalPrice" scope="page"
							value="${entry.key.unitPrice*entry.value+totalPrice}" />
		
					</c:forEach>
					
					<h3>YOUR ORDER</h3>
					<table class="table-your-order">
						<tr>
							<td>Bussiness Plus</td>
							<td>${totalPrice*0.1}</td>
						</tr>
						<tr>
							<td>Subscript (Annual)</td>

						</tr>
					</table>
					<c:set var="today" value="<%=  new java.util.Date()%>" />
					 <p>Date: <fmt:formatDate pattern = "yyyy-MM-dd" 
        			 value = "${today}" /></p>
					 
					<table class="table-your-order dashed-line position-text">
						<tr>
							<td>Total Purchases</td>
							<td>${totalPrice }</td>
						</tr>
						<tr>
							<td>Esimatated tax</td>
							<td>${totalPrice*0.1}</td>
						</tr>
						<tr class="dashed-line">
							<td>Total</td>
							<td>${totalPrice*1.2}</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>