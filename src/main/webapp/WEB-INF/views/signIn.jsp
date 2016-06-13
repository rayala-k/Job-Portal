<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login - Job Portal</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>



<!-- BootstrapValidator -->
<script src="js/bootstrapValidator.min.js" type="text/javascript"></script>
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

#login-form .form-control-feedback {
	right: 15px;
}
</style>
<!-- BootstrapValidator CSS -->
<link href="css/bootstrapValidator.min.css" rel="stylesheet" />
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
				<a href="Landing.jsp" class="navbar-brand" title="Home">Job
					Portal</a>

			</div>
			<!-- THE STUFF IN THIS DIV WILL COLLAPSE.. -->
			<div id="bs-navbar-collapse" class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="login.htm" class="active">Login</a></li>
					<li><a href="register.htm">Sign Up</a></li>
				</ul>

			</div>
		</div>
	</nav>

	<div class="document-title">
		<div class="container">
			<h1 class="center">Login</h1>
		</div>
		<!-- /.container -->
	</div>




	<div class="container">
		<c:if test="${not empty registrationSuccess}">
			<div class="alert alert-success">
				<strong>Success!</strong> Account has been created successfully.
			</div>
		</c:if>

		<form role="form" id="login-form" action="login.htm" method="post">
			<div class="row">
				<div class="form-group col-xs-6 col-lg-6">
					<label for="username">Username</label> <input type="text"
						class="form-control" id="username" name="username" />
				</div>
			</div>



			<div class="row">
				<div class="form-group col-xs-6 col-lg-6">
					<label for="password">Password</label> <input type="password"
						class="form-control" id="password" name="password" />
				</div>
			</div>




			<div class="row">

				<button type="submit" class="btn btn-primary">Login</button>
			</div>
		</form>


	</div>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var validator = $("#login-form")
									.bootstrapValidator(
											{
												feedbackIcons : {
													valid : "glyphicon glyphicon-ok",
													invalid : "glyphicon glyphicon-remove",
													validating : "glyphicon glyphicon-refresh"
												},
												fields : {

													username : {
														message : "Username is required",
														validators : {
															notEmpty : {
																message : "Please enter Username"
															},
															stringLength : {
																min : 8,
																message : "Username must contain atleast 8 characters"
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
															}
														}
													}
												}
											});

							

						});
	</script>
</body>
</html>
