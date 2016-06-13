<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Registration-Job Portal</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>



<!-- BootstrapValidator -->
<script src="resources/js/bootstrapValidator.min.js"
	type="text/javascript"></script>
<style>
@import url('http://getbootstrap.com/dist/css/bootstrap.css');

.no-collapse li, .no-collapse li a {
	text-align: center;
	float: none;
	display: inline-block;
}

.navbar-default {
	background-color: #ffffff;
}

.navbar-default .navbar-nav>li>a {
	color: #363636;
	font-size: 13px;
	font-weight: 600;
}

.navbar-nav>li>.active {
	border-bottom: 2px solid #ad1f2d !important;
}

.document-title {
	background-image:
		url("resources/map.png");
	background-position: center -320px;
	border-bottom: 1px solid #e9e9e9;
	margin: -30px 0px 40px 0px;
	padding: 48px 0px;
}

.document-title h1 {
	font-size: 32px;
	font-weight: 300;
	margin: 0px;
	padding: 0px;
}

.center {
	text-align: center;
}

#registration-form .form-control-feedback {
	right: 15px;
}
</style>
<!-- BootstrapValidator CSS -->
<link href="resources/css/bootstrapValidator.min.css" rel="stylesheet" />
</head>
<body>

	<nav role="navigation" id="headerNav"
		class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" data-toggle="collapse"
					data-target="#bs-navbar-collapse" class="navbar-toggle">
					<span class="sr-only">Job Portal menu</span> <span class="icon-bar"></span>
					<span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a href="Landing.html" class="navbar-brand" title="Home">Job
					Portal</a>

			</div>
			<!-- THE STUFF IN THIS DIV WILL COLLAPSE.. -->
			<div id="bs-navbar-collapse" class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="SignIn.html">Login</a></li>
					<li><a href="register.htm" class="active">Sign Up</a></li>
				</ul>

			</div>
		</div>
	</nav>

	<div class="document-title">
		<div class="container">
			<h1 class="center">Account Registration</h1>
		</div>
		<!-- /.container -->
	</div>

	<div class="container">

		<form:form role="form" action="register.htm" commandName="person"
			id="registration-form" method="post">
			<div class="row">
				<div class="form-group col-xs-6 col-lg-6">
					<label for="firstName">First Name</label>
					<form:input type="text" class="form-control" id="firstName"
						name="firstName" path="firstName" />
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-xs-6 col-lg-6">
					<label for="lastName">Middle Name</label>
					<form:input type="text" class="form-control" id="middleName"
						name="middleName" path="middleName" />
				</div>
			</div>

			<div class="row">
				<div class="form-group col-xs-6 col-lg-6">
					<label for="lastName">Last Name</label>
					<form:input type="text" class="form-control" id="lastName"
						name="lastName" path="lastName" />
				</div>
			</div>

			<div class="row">
				<div class="form-group col-xs-6 col-lg-6">
					<label for="userName">Username</label>
					<form:input type="text" class="form-control" id="userName"
						name="userName" path="userName" />
				</div>
			</div>
			
			

			<div class="row">
				<div class="form-group col-xs-6 col-lg-6">
					<label for="email">Email</label>
					<form:input type="email" class="form-control" id="email"
						name="email" path="email" />
				</div>
			</div>

			<div class="row">
				<div class="form-group col-xs-6 col-lg-6">
					<label for="password">Password</label>
					<form:input type="password" class="form-control" path="password"
						id="password" name="password" />
				</div>
			</div>

			<div class="row">
				<div class="form-group col-xs-6 col-lg-6">
					<label for="confirmPassword">Confirm Password</label>
					<form:input type="password" class="form-control"
						id="confirmPassword" name="confirmPassword" path="confirmPassword" />
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-xs-6 col-lg-6">
					<label for="confirmPassword">Mobile Number</label>
					<form:input type="text" class="form-control"
						id="mobileNumber" name="mobileNumber" path="mobileNumber" />
				</div>
			</div>

			<div class="row">
				<div class="form-group col-xs-6 col-lg-6">
					<label for="role">I am looking ..</label>
					<form:select class="form-control" id="role" path="role">
						<option value="jobseeker">..for a job</option>
						<option value="employer">..to hire</option>
					</form:select>
				</div>
			</div>


			<div class="row">

				<button type="submit" class="btn btn-primary">Register</button>
			</div>
		</form:form>


	</div>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var validator = $("#registration-form")
									.bootstrapValidator(
											{
												feedbackIcons : {
													valid : "glyphicon glyphicon-ok",
													invalid : "glyphicon glyphicon-remove",
													validating : "glyphicon glyphicon-refresh"
												},
												fields : {
													email : {
														message : "Email address is required",
														validators : {
															notEmpty : {
																message : "Please provide an email address"
															},
															stringLength : {
																min : 6,
																max : 35,
																message : "Email address must be between 6 and 35 characters long"
															},
															emailAddress : {
																message : "Email address was invalid"
															}
														}
													},
													userName : {
														message : "Username is required",
														validators : {
															notEmpty : {
																message : "Please enter Username"
															},
															stringLength : {
																min : 8,
																max : 25,
																message : "Username must be between 8 and 25 characters long"
															}
														}
													},
													lastName : {
														message : "Last Name is required",
														validators : {
															notEmpty : {
																message : "Please enter Last Name"
															},
															stringLength : {
																min : 2,
																message : "Last Name must be atleast two characters long"
															}
														}
													},
													firstName : {
														message : "First Name is required",
														validators : {
															notEmpty : {
																message : "Please enter First Name"
															},
															stringLength : {
																min : 2,
																message : "First Name must be atleast two characters long"
															}
														}
													},
													password : {
														validators : {
															notEmpty : {
																message : "Password is required"
															},
															stringLength : {
																min : 8,
																message : "Password must be 8 characters long"
															},
															different : {
																field : "confirmPassword",
																message : "Password and confirmation must match"
															}
														}
													},
													confirmPassword : {
														validators : {
															notEmpty : {
																message : "Confirm password field is required"
															},
															identical : {
																field : "password",
																message : "Password and confirmation must match"
															}
														}
													}
												}
											});

						});
	</script>
</body>
</html>
