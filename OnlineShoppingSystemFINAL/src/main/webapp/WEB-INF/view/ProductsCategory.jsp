<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="./common/header.jsp">
	<jsp:param value="Product Category" name="title" />
</jsp:include>
<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>Shop</h2>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="single-product-area">
	<div class="zigzag-bottom"></div>
	<div class="container">
		<div class="row">
			<c:forEach items="${lstProduct }" var="product">
				<div class="col-md-3 col-sm-6">
					<div class="single-shop-product">
						<div class="product-upper">
							<img
								src="${pageContext.request.contextPath}/resources/img/product/${product.code }.jpg"
								style="width: 195px; height: 240px" alt="">
						</div>
						<h2>
							<a href="">${product.productName }</a>
						</h2>
						<div class="product-carousel-price">
							<ins>$ ${product.unitPrice }</ins>
							<del>$999.00</del>
						</div>

						<div class="product-option-shop">
							<a class="add_to_cart_button btn btn-info" data-id="${product.productId}">Add
								to cart</a>
							<a href="productDetails?id=${product.productId}&pageNumber=1" 
							class="btn btn-warning" data-id="${product.productId}">See
								Details</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

	</div>
</div>

<div class="row">
	<div class="col-md-12">
		<div class="product-pagination text-center">
			<nav>
				<ul class="pagination">
					<li><a href="#" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>
</div>

<%@ include file="./common/footer.jsp"%>