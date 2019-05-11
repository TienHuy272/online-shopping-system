<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Card</title>
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
</head>
<body> --%>
<jsp:include page="./common/header.jsp">
	<jsp:param value="Home" name="title" />
</jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- End mainmenu area -->
<div class="container" style="margin-top: 40px">  
	<div class="head">  
		<h3>All The Selected Products In Your Cart</h3>
	</div>
	<div id="Clear-Cart">
		<a href="clearCart" class="btn btn-danger" role="button"> <img
			style="width: 22px; height: 22px" id="clear" alt="#"
			src="resources/img/clear.png">Clear Cart

		</a> <a href="re-checkout" class="btn btn-success" role="button"> <img
			style="width: 22px; height: 22px" id="order" alt="#"
			src="resources/img/order.png">Check Out
		</a>
	</div>

	<div>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>Product</th>
					<th>Quantity</th>
					<th>Unit Price</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
			<thead class="thead-dark">
				<c:forEach var="entry" items="${listOrderProduct}">
					<tr id="${entry.key.productId}">
						<td><c:out value="${entry.key.productName}" /></td>
						<%-- <td><c:out value="${entry.value}" /></td> --%>

						<%-- <td><input type="number" id="${entry.key.productId}"
								class="quantity" data-id="entry.key.productId" name="quantity"
								value="${entry.value}"></td> --%>

						<td><input type="number" class="quantity"
							data-id="${entry.key.productId}" name="quantity"
							value="${entry.value}" min="1" max="${entry.key.unitInStock}">
						</td>

						<%-- <td><c:out value="${entry.key.unitPrice}" /></td>
							<td><c:out value="${entry.key.unitPrice*entry.value}" /></td> --%>

						<td><span id="${entry.key.productId}UnitPrice">${entry.key.unitPrice}</span>
						</td>
						<td><span id="${entry.key.productId}Price">${entry.key.unitPrice*entry.value}</span>
						</td>
						<%-- <td><a href="removeProduct?id=${entry.key.productId}">Remove</a> --%>
						<td><button type="button" class="remove"
								data-id="${entry.key.productId}">Remove</button></td>
					</tr>
				</c:forEach>
		</table>
	</div>
	<div id="result"></div>
	<div style="margin-bottom: 30px">  
		<a href="productList?pageNumber=1" class="btn btn-success"
			role="button"> <img id="order" alt="#"
			src="resources/img/back.png" style="width: 24px; height: 24px;">Continue shopping
		</a>
	
	</div>
</div>

<jsp:include page="./common/footer.jsp" />