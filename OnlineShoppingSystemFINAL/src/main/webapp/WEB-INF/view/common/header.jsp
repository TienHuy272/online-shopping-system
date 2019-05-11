<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><%=request.getParameter("title")%></title>

<!-- Google Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Raleway:400,100'
	rel='stylesheet' type='text/css'>

<!-- Bootstrap -->
<link rel="stylesheet"
	href="${contextRoot }/resources/css/bootstrap.min.css">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="${contextRoot}/resources/css/font-awesome.min.css">

<!-- Custom CSS -->
<link rel="stylesheet"
	href="${contextRoot}/resources/css/owl.carousel.css">
<link rel="stylesheet"
	href="${contextRoot}/resources/css/style-temple.css">
<link rel="stylesheet"
	href="${contextRoot}/resources/css/responsive.css">

<!-- Search Product CSS -->
<link rel="stylesheet"
	href="${contextRoot}/resources/css/searchproduct.css">

</head>

<body>
	<div class="header-area">
	
	<c:set var="totalPrice" scope="page" value="0.0" />
		<c:set var="numberOfProduct" scope="page" value="0" />
		<c:forEach var="entry" items="${listOrderProduct}">
			<c:set var="totalPrice" scope="page"
				value="${entry.key.unitPrice*entry.value+totalPrice}" />
			<c:set var="numberOfProduct" scope="page"
				value="${entry.value+numberOfProduct}" />
		</c:forEach>
		
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div class="user-menu">
						<ul>
						<c:if test="${theCustomer != null }">
							<li><a href="${contextRoot}/customerProfile"><i
									class="fa fa-user"></i>My Account</a></li>
							<li><a href="viewCart"><i class="fa fa-user"></i> My
									Cart</a></li>
							<li><a href="re-checkout"><i class="fa fa-user"></i>
									Checkout</a></li>
						</c:if>
						<c:if test="${theAdmin != null}">
							<li><a href="${contextRoot}/adminProfile"><i
									class="fa fa-user"></i>My Account</a></li>
						</c:if>
						<c:if test="${theCustomer == null}">
							
							<li><a href="${contextRoot}/customerLogin"><i
									class="fa fa-user"></i>Customer Login</a></li>
						</c:if>
						<c:if test="${theAdmin == null }">
							<li><a href="${contextRoot}/adminLogin"><i
									class="fa fa-user"></i>Admin Login</a></li>
						</c:if>
						</ul>
					</div>
				</div>


			</div>
		</div>
	</div>
	<!-- End header area -->

	<div class="site-branding-area">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="logo">
						<h1>
							<a href="${contextRoot }/homePage"><img
								src="${contextRoot }/resources/img/logo.png"></a>
						</h1>
					</div>
				</div>

				<div class="col-sm-6">
					<div class="shopping-item">
						<a href="viewCart">Cart - <span class="cart-amunt">${totalPrice }</span>
							<i class="fa fa-shopping-cart"></i> <span class="product-count">${numberOfProduct }</span></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End site branding area -->

	<div class="mainmenu-area">
		<div class="container">
			<div class="row">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="col-sm-6">
					<div class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="active"><a href="${contextRoot }/homePage">Home</a></li>
							<li class=""><a
								href="${contextRoot}/productList?pageNumber=1">Shop page</a></li>
							<li class="dropdown" id="dropdown-menu-button"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false">Category </a>
								<ul class="dropdown-menu" id="dropdown-menu-button-ul">
									<c:forEach items="${lstCategory }" var="category">
										<%-- <li><a
											href="${contextRoot}/category/${category.categoryId }">${category.categoryName }</a></li> --%>
										<li><a
											href="showProductByCategory?categoryId=${category.categoryId }">${category.categoryName }</a></li>
									</c:forEach>
								</ul></li>
							<li class="dropdown" id="dropdown-menu-button"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false">Manufacturer </a>
								<ul class="dropdown-menu" id="dropdown-menu-button-ul">
									<c:forEach items="${lstManufacturer }" var="manufacturer">
										<%-- <li><a
											href="${contextRoot}/manufacturer/${manufacturer.manufacturerId }">${manufacturer.manufacturerName }</a></li> --%>
										<li><a
											href="showProductByManufacturer?manufacturerId=${manufacturer.manufacturerId }">${manufacturer.manufacturerName }</a></li>
									</c:forEach>
								</ul></li>

						</ul>
					</div>

				</div>
				<div class="col-sm-6 title_right">
					<div
						class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
						<div class="input-group">
							<form action="getProductListByName" method="post">
								<input type="text" class="search-style form-control"
									id="searchProductName" name="productName"
									placeholder="Search for..."> <span
									class="input-group-btn"> <!-- <button class="btn btn-default btn-style" type="button">Go!</button> -->
								</span>
							</form>
						</div>
						<div id="resultSearch" class="resultSearch"></div>
					</div>
				</div>
			</div>
		</div>
	</div>