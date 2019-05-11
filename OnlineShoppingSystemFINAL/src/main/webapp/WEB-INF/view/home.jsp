<jsp:include page="./common/header.jsp">
	<jsp:param value="Home" name="title" />
</jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="slider-area">
	<!-- Slider -->
	<div class="block-slider block-slider4">
		<ul class="" id="bxslider-home4">
			<li><img src="resources/img/h4-slide.png" alt="Slide">
				<div class="caption-group">
					<h2 class="caption title">
						iPhone <span class="primary">6 <strong>Plus</strong></span>
					</h2>
					<h4 class="caption subtitle">Dual SIM</h4>
					<a class="caption button-radius" href="#"><span class="icon"></span>Shop
						now</a>
				</div></li>
			<li><img src="resources/img/h4-slide2.png" alt="Slide">
				<div class="caption-group">
					<h2 class="caption title">
						by one, get one <span class="primary">50% <strong>off</strong></span>
					</h2>
					<h4 class="caption subtitle">school supplies & backpacks.*</h4>
					<a class="caption button-radius" href="#"><span class="icon"></span>Shop
						now</a>
				</div></li>
			<li><img src="resources/img/h4-slide3.png" alt="Slide">
				<div class="caption-group">
					<h2 class="caption title">
						Apple <span class="primary">Store <strong>Ipod</strong></span>
					</h2>
					<h4 class="caption subtitle">Select Item</h4>
					<a class="caption button-radius" href="#"><span class="icon"></span>Shop
						now</a>
				</div></li>
			<li><img src="resources/img/h4-slide4.png" alt="Slide">
				<div class="caption-group">
					<h2 class="caption title">
						Apple <span class="primary">Store <strong>Ipod</strong></span>
					</h2>
					<h4 class="caption subtitle">& Phone</h4>
					<a class="caption button-radius" href="#"><span class="icon"></span>Shop
						now</a>
				</div></li>
		</ul>
	</div>
	<!-- ./Slider -->
</div>
<!-- End slider area -->

<div class="promo-area">
	<div class="zigzag-bottom"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-6">
				<div class="single-promo promo1">
					<i class="fa fa-refresh"></i>
					<p>30 Days return</p>
				</div>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="single-promo promo2">
					<i class="fa fa-truck"></i>
					<p>Free shipping</p>
				</div>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="single-promo promo3">
					<i class="fa fa-lock"></i>
					<p>Secure payments</p>
				</div>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="single-promo promo4">
					<i class="fa fa-gift"></i>
					<p>New products</p>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- End promo area -->

<!-- main content area -->

<div class="maincontent-area">
	<div class="zigzag-bottom"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="latest-product">
					<h2 class="section-title">Latest Products</h2>
					<div class="product-carousel">
						<c:forEach items="${productList }" var="product">
							<div class="single-product">
								<div class="product-f-image">
									<img src="resources/img/product/${product.code}.jpg "
										style="width: 195px; height: 280px" alt="">
									<div class="product-hover">
										<a
											href="${pageContext.request.contextPath}/productDetails?id=${product.productId}&pageNumber=1"
											class="add-to-cart-link"><i class="fa fa-shopping-cart"></i>
											See Details</a>
										<%-- href="${pageContext.request.contextPath}/productOrder?id=${product.productId}&pageNumber=1&from=""
											class="view-details-link"><i class="fa fa-link"></i>Add
											To Cart</a> --%>
										<a class="view-details-link add_to_cart_button btn" data-id="${product.productId}"><i
											class="fa fa-link"></i>Add To Cart</a>
									</div>
								</div>

								<h2>
									<a href="productDetails?id=${product.productId}">${product.productName }</a>
								</h2>

								<div class="product-carousel-price">
									<ins>$ ${product.unitPrice }</ins>
									<del>$100.00</del>
								</div>
							</div>
						</c:forEach>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- End main content area -->

<div class="brands-area">
	<div class="zigzag-bottom"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="brand-wrapper">
					<div class="brand-list">
						<img src="resources/img/brand1.png" alt=""> <img
							src="resources/img/brand2.png" alt=""> <img
							src="resources/img/brand3.png" alt=""> <img
							src="resources/img/brand4.png" alt=""> <img
							src="resources/img/brand5.png" alt=""> <img
							src="resources/img/brand6.png" alt=""> <img
							src="resources/img/brand1.png" alt=""> <img
							src="resources/img/brand2.png" alt="">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="./common/footer.jsp"%>