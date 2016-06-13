<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Home - Job Seeker</title>

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
	margin-left: 80px;
}

#headerNav {
	margin-bottom: 0px;
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

.jobSeekerSearchBar {
	background-color: white;
	border-bottom: 1px solid #DDDDDD;
}

.navbar {
	margin-bottom: 0px;
}

#profileIcon {
	margin: 2px;
}

#profileEditButton {
	color: #069;
	border-color: #069;
}

.marginTop10 {
	margin-top: 10px;
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
				<a href="#" class="navbar-brand" title="Home">Job Portal</a>

			</div>
			<!-- THE STUFF IN THIS DIV WILL COLLAPSE.. -->
			<div id="bs-navbar-collapse" class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Login</a></li>
					<li><a href="#">Sign Up</a></li>
				</ul>

			</div>
		</div>
	</nav>


	<div class="navbar navbar-inverse" role="navigation">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

		</div>

		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav searhBarNav">
				<li class="active"><a href="/topic/notes/">Home</a></li>
				<li><a href="/topic/notes/">Profile</a></li>
			</ul>
		</div>
	</div>


	<div class="jumbotron jobSeekerSearchBar">
		<div class="container">
			<form role="form">
				<div class="row-fluid">
					<div class="col-sm-5 form-group has-feedback">
						<input class="form-control  input-lg" id="ex1" type="text"
							placeholder="job title, keywords or company name"> <span
							class="glyphicon glyphicon-time form-control-feedback"
							style="font-size: 20px; margin-right: 10px;"></span>
					</div>
					<div class="col-sm-5 form-group has-feedback">
						<input class="form-control  input-lg" id="ex2" type="text"
							placeholder="city, province or region"> <span
							class="glyphicon glyphicon-map-marker form-control-feedback"
							style="font-size: 20px; margin-right: 10px;"></span>
					</div>
					<div class="col-sm-2">
						<a href="#" class="btn btn-success btn-lg">Find Job</a>
					</div>
				</div>
			</form>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<h2>About Company Page</h2>
			</div>
			<div class="col-md-3">
				<a href="resume.htm" class="btn btn-default btn-lg marginTop10"
					id="profileEditButton">
					<span class="glyphicon glyphicon-pencil pull-left" id="profileIcon"></span>
					Create profile
				</a>
			</div>
		</div>
		<hr/>
		<h4>Lorem ipsum..</h4>
		<p>Lorem ipsum..</p>
	</div>
</body>
</html>
