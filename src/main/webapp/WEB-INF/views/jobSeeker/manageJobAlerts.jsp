<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Home - Job Seeker</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<script src="resources/js/app.js" type="text/javascript"></script>

<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.js"></script>
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

.customBtn {
	margin-top: -35px;
	margin-right: -100px;
}

ul.list-group:after {
	clear: both;
	display: block;
	content: "";
}

.list-group-item {
	float: left;
}

.skillList {
	margin: 3px;
}

.skillIcon {
	margin-left: 6px;
	margin-top: 2px;
}

li {
	cursor: pointer;
	cursor: hand;
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
					<li><a href="logout.htm">Logout</a></li>	
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
				<li><a href="jobSeekerHome.htm">Home</a></li>
				<li><a href="#">Profile</a></li>
				
				<li><a href="availableJobs.htm">Available Jobs</a></li>
				<li><a href="getAppliedJobs.htm">Applied Jobs</a></li>
				<li class="active"><a href="manageJobAlerts.htm">Manage Job Alerts</a></li>
			</ul>
		</div>
	</div>

	<div class="document-title">
		<div class="container">
			<h1 class="center">Create a Job Alert</h1>
		</div>
		<!-- /.container -->
	</div>


	<div class="container">
		<form role="form" id="jobAlert-form" method="post" action="createJobAlert.htm">

			<div class="row">
				<div class="form-group col-xs-6 col-lg-6">
					<label for="alertName">Job Alert Name</label> <input
						type="text" class="form-control" id="alertName"
						name="alertName" />
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-xs-6 col-lg-6">
					<label for="alertName">Location</label> <input
						type="text" class="form-control" id="location"
						name="location" />
				</div>
			</div>

			

			<div class="row">
				<div class="form-group col-lg-3">
					<label for="gpa">KeyWord</label> <input type="text"
						class="form-control" id="skill" name="skill" /> <a
						class="btn btn-info pull-right customBtn" id="addSkill">Add
						</a>
				</div>
			</div>

			<div class="row" style="display: none;">
				<div class="form-group col-xs-6 col-lg-6">
					<select name="addedSkills" multiple id="fromDay"
						class="form-control">
					</select>
				</div>
			</div>

			<div class="row well">
				<ul class="list-group" id="skillList">

				</ul>
			</div>

			<hr />




			<br>

			<div class="row">

				<button type="submit" class="btn btn-primary">Create Job Alert</button>
			</div>
		</form>


	</div>
</body>
</html>
