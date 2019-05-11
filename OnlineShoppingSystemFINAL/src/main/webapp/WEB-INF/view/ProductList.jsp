<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="./common/header.jsp">
	<jsp:param value="Product List" name="title" />
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
			<c:forEach items="${productList }" var="product">
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
							<a href="productDetails?id=${product.productId}&pageNumber=${pageNumber}" 
							class="btn btn-warning" data-id="${product.productId}">See
								Details</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

	</div>
</div>
<c:set var="pageNumber" scope="page" value="${pageNumber}" />
<c:set var="totalProduct" scope="page" value="${totalProduct}" />
<div class="row">
	<div class="col-md-12">
		<div class="product-pagination text-center">
			<nav>
				<ul class="pagination">
					<c:if test="${pageNumber > 1 }">
						<li><a href="getListProduct?pageNumber=${pageNumber - 1}">
								<span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>
					<li><a href="getListProduct?pageNumber=${pageNumber}">${pageNumber}</a>
					</li>
					<c:if test="${pageNumber < numberOfPage }">
						<li><a href="getListProduct?pageNumber=${pageNumber + 1}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
</div>

<jsp:include page="./common/footer.jsp" />