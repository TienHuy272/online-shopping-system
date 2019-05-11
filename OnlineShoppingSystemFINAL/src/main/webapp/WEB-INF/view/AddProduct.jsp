<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="./admincommon/HeaderAdmin.jsp">
	<jsp:param value="Add Product" name="title" />
</jsp:include>
<!-- page content -->
<div class="right_col min-height-body" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>Add New Product</h3>
			</div>

			<div class="title_right">
				<div
					class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Search for..."> <span
							class="input-group-btn">
							<button class="btn btn-default" type="button">Go!</button>
						</span>
					</div>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>


		<div class="row">
			<div class="col-md-12 col-xs-12 ">
				<div class="x_panel">
					<div class="x_content">
						<br />
						<div class="content">
							<form:form action="postProduct" method="POST"
								modelAttribute="product" enctype="multipart/form-data">
								<div class="form-group row">
									<label for="productName"
										class="col-sm-3 col-form-label position-text">Product
										Name</label>
									<div class="col-sm-4">
										<form:input type="text" class="form-control" id="productName"
											name="productName" path="productName" />
									</div>
								</div>
								<div class="form-group row">
									<label for="unitPrice"
										class="col-sm-3 col-form-label position-text">Unit
										Price</label>
									<div class="col-sm-4">
										<form:input type="text" class="form-control" id="unitPrice"
											name="unitPrice" path="unitPrice" />
									</div>
								</div>
								<div class="form-group row">
									<label for="unitInStock"
										class="col-sm-3 col-form-label position-text">Units in
										Stock</label>
									<div class="col-sm-4">
										<form:input type="text" class="form-control" id="unitInStock"
											name="unitInStock" PlaceHolder="0" path="unitInStock" />
									</div>
								</div>
								<div class="form-group row">
									<label for="description"
										class="col-sm-3 col-form-label position-text">Description</label>
									<div class="col-sm-4">
										<form:textarea class="form-control" id="description"
											name="description" rows="3" path="description" />
									</div>
								</div>
								<div class="form-group row">
									<label for="manufacturer"
										class="col-sm-3 col-form-label position-text">Manufacturer</label>
									<div class="col-sm-4">
										<form:select path="manufacturer.manufacturerId"
											class="form-control position-text-option">
											<form:option value="0" label="--Please Select" />
											<form:options items="${lstManufacturer}"
												itemValue="manufacturerId" itemLabel="manufacturerName" />
										</form:select>
									</div>
								</div>
								<div class="form-group row">
									<label for="category"
										class="col-sm-3 col-form-label position-text">Category</label>
									<div class="col-sm-4">
										<form:select path="category.categoryId"
											class="form-control position-text-option">
											<form:option value="0" label="--Please Select" />
											<form:options items="${lstCategory}" itemValue="categoryId"
												itemLabel="categoryName" />
										</form:select>
									</div>
								</div>
								<div class="form-group row">
									<label for="condition"
										class="col-sm-3 col-form-label position-text">Condition</label>
									<div class="col-sm-4 ">
										<div class="radio-inline">
											<form:radiobutton class="form-check-input" path="condition"
												value="new" label="New" />
										</div>
										<div class="radio-inline">
											<form:radiobutton class="form-check-input" path="condition"
												value="old" label="Old" />
										</div>
										<div class="radio-inline">
											<form:radiobutton class="form-check-input" path="condition"
												value="refurbished" label="Refurbished" />
										</div>
									</div>
								</div>
								<div class="form-group row">
									<label for="file" class="col-sm-3 col-form-label position-text">Product
										Image File</label>
									<div class="col-sm-4">
										<form:input type="file" path="file" class="form-control" />
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-3"></div>
									<div class="col-sm-9">
										<form:button type="submit" id="save" name="submit"
											class="btn btn-primary">Add Product</form:button>
									</div>
								</div>
							</form:form>
						</div>


					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->
<jsp:include page="./admincommon/FooterAdmin.jsp"/>