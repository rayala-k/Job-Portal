<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Job Portal</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
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

.searhBarNav {
	margin-left: 70px;
}

.jumbotron {
	background-image:
		url('resources/banner.jpg');
	height: 100vh;
	background-size: 100% 100%;
}

.navbar {
	margin-bottom: 0px;
}

.homeSearchBar h2 {
	padding-top: 150px;
	font-size: 46px;
	color: #fff;
	margin-bottom: 30px;
	letter-spacing: -1px;
}

.browse-jobs {
	color: #fff;
	margin-top: 20px;
}

.browse-jobs a {
	background-color: rgba(255, 255, 255, 0.1);
	border: 1px solid rgba(255, 255, 255, 0.3);
	padding: 5px 10px;
	color: #fff;
	margin: 0 5px;
	text-decoration: none;
}

.announce {
	color: #fff;
	font-size: 24px;
	font-weight: 300;
	margin-top: 40px;
}

/* Overwrite bootsrap */
.row-offset-0 {
	margin-left: 0;
	margin-right: 0;
}

.row-offset-0>* {
	padding-left: 0;
	padding-right: 0;
}

.customWell {
	max-height: 157px;
}

.customWell a {
	margin: -1px 0 0 -1px;
	text-align: center;
	font-size: 14px;
	text-transform: uppercase;
	color: #666;
	padding: 45px 15px;
	text-decoration: none;
}

.well:default {
	background-color: #ffffff;
	border: 1px solid #e0e0e0;
}

.well:hover {
	background-color: #fff;
	border: 1px solid green;
}

.loop-item-title {
	color: #44494b;
	font-size: 14px;
}

.loop-item-title a {
	text-decoration: none;
	color: #44494b;
	font-size: 14px;
	text-transform: none;
}
</style>
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
					<li><a href="login.htm">Login</a></li>
					<li><a href="register.htm">Sign Up</a></li>
				</ul>
			</div>
		</div>
	</nav>




	<div class="jumbotron">
		<div class="container homeSearchBar">
			<form role="form" action="searchFromHome.htm">
				<h2 style="color: #ffffff">Find Job</h2>
				<div class="row-fluid">
					<div class="col-sm-3 form-group has-feedback">
						<input class="form-control  input-lg" id="jobTitle" name="jobTitle" type="text"
							placeholder="job title"> <span
							class="glyphicon glyphicon-time form-control-feedback"
							style="font-size: 20px; margin-right: 10px;"></span>
					</div>
					<div class="col-sm-3 form-group has-feedback">
						<input class="form-control  input-lg" id="skill" name="skill" type="text"
							placeholder="skill"> <span
							class="glyphicon glyphicon-briefcase form-control-feedback"
							style="font-size: 20px; margin-right: 10px;"></span>
					</div>
					<div class="col-sm-3 form-group has-feedback">
						<input class="form-control  input-lg" id="companyName" name="companyName" type="text"
							placeholder="company"> <span
							class="glyphicon glyphicon-briefcase form-control-feedback"
							style="font-size: 20px; margin-right: 10px;"></span>
					</div>
					<div class="col-sm-3 form-group has-feedback">
						<input class="form-control  input-lg" id="location" name="location" type="text"
							placeholder="location"> <span
							class="glyphicon glyphicon-map-marker form-control-feedback"
							style="font-size: 20px; margin-right: 10px;"></span>
					</div>					
				</div>
				<div class="row-fluid">
					<div class="col-sm-2">
						<button class="btn btn-success btn-lg"><span
							class="glyphicon glyphicon-search"></span></button>
					</div>
				</div>
				
			</form>
			
			<div class="clearfix"></div>
			<div class="row">
				<div class="announce col-sm-5">
					We have <strong>23</strong> job offers for you!
				</div>
			</div>
		</div>
	</div>

	
</body>
</html>
