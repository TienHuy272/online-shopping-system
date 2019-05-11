<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	  
    <title>Profile</title>

    <!-- Bootstrap -->
    <link href="resources/vendors/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
	<link href="resources/vendors/css/daterangepicker.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="resources/vendors/css/custom.min.css" rel="stylesheet">
    <!-- style css -->
    <link href="resources/css/style.css" rel="stylesheet">

  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="homePage" class="site_title"><i class="fa fa-paw"></i> <span>SHOPPING ONLINE</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              
              <div class="profile_info">
                <span>Welcome,</span>
                <h2 class="upcase-text">${theCustomer.firstName}</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
             <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a href="customerProfile"><i class="fa fa-home"></i> Home </a>
                  </li>
                  <li><a><i class="fa fa-key" aria-hidden="true"></i>Change Password</span></a>
                  </li>
                </ul>
              </div>
            </div>
            <!-- /sidebar menu -->

      
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src="images/img.jpg" alt=""><label class="upcase-text">${theCustomer.firstName}</label>
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="javascript:;"> Profile</a></li>
                    <li><a href="logout"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                  </ul>
                </li>
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col min-height-body" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Profile</h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Go!</button>
                    </span>
                  </div>
                </div>
              </div>
            </div>
            <div class="clearfix"></div>
          

            <div class="row">
              <div class="col-md-6 col-xs-12 col-md-offset-3">
                <div class="x_panel">
                  <div class="x_content">
                    <br />
                    <form:form action="updateProfile" modelAttribute="theCustomer" method="post" class="form-horizontal form-label-left input_mask">

                      <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                        <form:input path="firstName" type="text" class="form-control has-feedback-left" id="inputSuccess2" placeholder="First Name"/>
                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                      </div>

                      <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                        <form:input path="lastName" type="text" class="form-control" id="inputSuccess3" placeholder="Last Name"/>
                        <span class="fa fa-user form-control-feedback right" aria-hidden="true"></span>
                      </div>

                      <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                        <input type="text" class="form-control has-feedback-left" id="inputSuccess4" placeholder="Email">
                        <span class="fa fa-envelope form-control-feedback left" aria-hidden="true"></span>
                      </div>

                      <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                        <form:input path="phone" type="text" class="form-control" id="inputSuccess5" placeholder="Phone"/>
                        <span class="fa fa-phone form-control-feedback right" aria-hidden="true"></span>
                      </div>

                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Company Name</label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                          <form:input path="companyName" type="text" class="form-control" placeholder="Company Name"/>
                        </div>
                      </div>
					  
					   <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">City</label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                          <form:input path="city" type="text" class="form-control" placeholder="City"/>
                        </div>
                      </div>
					  
					  <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">State</label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                          <form:input path="state" type="text" class="form-control" placeholder="State"/>
                        </div>
                      </div>
                     
					  <div class="form-group">
					    <label class="control-label col-md-3 col-sm-3 col-xs-12">Date Of Birth <span class="required">*</span>
                        </label>
						<div class="col-md-9 has-feedback">
							<input type="text" class="form-control has-feedback-left" id="single_cal1" placeholder="Date Of Birth" aria-describedby="inputSuccess2Status">
							<span class="fa fa-calendar-o form-control-feedback left" aria-hidden="true"></span>
							<span id="inputSuccess2Status" class="sr-only">(success)</span>
						</div>
					  </div>
					  <form:hidden path="customerId" value="${theCustomer.customerId }"/>
					  <form:hidden path="userName" value="${theCustomer.userName }"/>
					  <form:hidden path="password" value="${theCustomer.password }"/>
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
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->

       
    </div>

    
 <!-- jQuery -->
    <script src="resources/vendors/js/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="resources/vendors/js/bootstrap.min.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="resources/vendors/js/moment.min.js"></script>
    <script src="resources/vendors/js/bootstrap-daterangepicker/daterangepicker.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="resources/vendors/js/custom.min.js"></script>
	
  </body>
</html>
