<jsp:include page="./admincommon/HeaderAdmin.jsp">
	<jsp:param value="Admin Profile" name="title"/>
</jsp:include>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- page content -->
<div class="right_col min-height-body" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>Admin Profile</h3>
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

		
		<%-- <div class="row">
			<div class="col-md-6 col-xs-12 col-md-offset-3">
				<div class="x_panel">
					<div class="x_content">
						<br />
						<form:form action="updateProfile" modelAttribute="theAdmin"
							method="post" class="form-horizontal form-label-left input_mask">

							<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
								<form:input path="firstName" type="text"
									class="form-control has-feedback-left" id="inputSuccess2"
									placeholder="First Name" />
								<span class="fa fa-user form-control-feedback left"
									aria-hidden="true"></span>
							</div>

							<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
								<form:input path="lastName" type="text" class="form-control"
									id="inputSuccess3" placeholder="Last Name" />
								<span class="fa fa-user form-control-feedback right"
									aria-hidden="true"></span>
							</div>

							<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
								<input type="text" class="form-control has-feedback-left"
									id="inputSuccess4" placeholder="Email"> <span
									class="fa fa-envelope form-control-feedback left"
									aria-hidden="true"></span>
							</div>

							<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
								<form:input path="phone" type="text" class="form-control"
									id="inputSuccess5" placeholder="Phone" />
								<span class="fa fa-phone form-control-feedback right"
									aria-hidden="true"></span>
							</div>

							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Company
									Name</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<form:input path="companyName" type="text" class="form-control"
										placeholder="Company Name" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">City</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<form:input path="city" type="text" class="form-control"
										placeholder="City" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">State</label>
								<div class="col-md-9 col-sm-9 col-xs-12">
									<form:input path="state" type="text" class="form-control"
										placeholder="State" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Date
									Of Birth <span class="required">*</span>
								</label>
								<div class="col-md-9 has-feedback">
									<input type="text" class="form-control has-feedback-left"
										id="single_cal1" placeholder="Date Of Birth"
										aria-describedby="inputSuccess2Status"> <span
										class="fa fa-calendar-o form-control-feedback left"
										aria-hidden="true"></span> <span id="inputSuccess2Status"
										class="sr-only">(success)</span>
								</div>
							</div>
							<form:hidden path="customerId" value="${theCustomer.customerId }" />
							<form:hidden path="userName" value="${theCustomer.userName }" />
							<form:hidden path="password" value="${theCustomer.password }" />
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
									<button type="button" class="btn btn-primary">Cancel</button>
									<button class="btn btn-primary" type="reset">Reset</button>
									<form:button type="submit" class="btn btn-success">Submit</form:button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div> --%>
	</div>
</div>
<!-- /page content -->
<jsp:include page="./admincommon/FooterAdmin.jsp" />