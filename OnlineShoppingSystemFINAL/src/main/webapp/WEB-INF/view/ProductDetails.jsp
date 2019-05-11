<jsp:include page="./common/header.jsp">
	<jsp:param value="Home" name="title" />
</jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="maincontent-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<img alt="#" src="resources/img/product/${product.code }.jpg">
			</div>
			<div class="col-lg-9">
				<h2>${product.productName }</h2>      <br>
				${product.description }				  <br>
				Item Code: ${product.productId }			  <br>
				Manufacturer: ${product.manufacturer }<br>
				Category: ${product.category }        <br>
				Available Unit in Stock: ${product.unitInStock }<br>
				${product.unitPrice } USD<br>
				<a href="getListProduct?pageNumber=${pageNumber}" class="btn btn-success" role="button">
		      		<img style="width: 20px; height: 20px"alt="#" src="resources/img/back.png">Back
		      	</a>
				<a  class="add_to_cart_button btn btn-info" data-id="${product.productId}" role="button">
		      		<img style="width: 24px; height: 24px" alt="#" src="resources/img/order.png">Order Now
		      	</a>
			</div>
		</div>
		</div>
	</div>
<%@ include file="./common/footer.jsp"%>