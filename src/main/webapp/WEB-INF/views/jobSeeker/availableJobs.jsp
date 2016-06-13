<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Home - Job Seeker</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
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
				
				<li class="active"><a href="availableJobs.htm">Available Jobs</a></li>
				<li><a href="getAppliedJobs.htm">Applied Jobs</a></li>
				<li><a href="manageJobAlerts.htm">Manage Job Alerts</a></li>
			</ul>
		</div>
	</div>

	<div class="jumbotron jobSeekerSearchBar">
		<div class="container">
			<form role="form" action="searchByCandidate.htm">
				<h2 style="color: #ffffff">Find Job</h2>
				<div class="row-fluid">
					<div class="col-sm-5 form-group has-feedback">
						<input class="form-control  input-lg" id="criteria1" name="criteria1" type="text"
							placeholder="job title, skill or company name"> <span
							class="glyphicon glyphicon-time form-control-feedback"
							style="font-size: 20px; margin-right: 10px;"></span>
					</div>
					<div class="col-sm-5 form-group has-feedback">
						<input class="form-control  input-lg" id="criteria2" name="criteria2" type="text"
							placeholder="city, province or region"> <span
							class="glyphicon glyphicon-map-marker form-control-feedback"
							style="font-size: 20px; margin-right: 10px;"></span>
					</div>
					<div class="col-sm-2">
						<button class="btn btn-success btn-lg"><span
							class="glyphicon glyphicon-search"></span></button>
					</div>
				</div>				
			</form>
		</div>
	</div>


	<div class="container">

		<!--left
		<div class="col-sm-3">
			<h2>Filter Results</h2>
			<div class="panel panel-default">
				<div class="panel-body">
					<label for="jobCategory">Job Category</label> <select
						name="jobCategory" class="form-control" id="jobCategory">
						<option value="Accounting / Finance">Accounting / Finance</option>
						<option value="Automotive">Automotive</option>
						<option value="Construction / Facilities">Construction / Facilities</option>
						<option value="Animation">Animation</option>
						<option value="HealthCare">HealthCare</option>
						<option value="Information Technology">Information Technology</option>
						<option value="Marketing">Marketing</option>
						<option value="Sales">Sales</option>
						<option value="Telecommunication">Telecommunication</option>
					</select>
					<hr>
					<label for="jobType">Job type</label> <select name="jobType"
						class="form-control" id="jobType">
						<option value="Full-Time">Full-Time</option>
						<option value="Part-Time">Part-Time</option>
						<option value="InternShip">InternShip</option>
					</select>
					<hr>
					<label for="educationRequirements">Education Requirements</label> <select
						name="educationRequirements" class="form-control"
						id="educationRequirements">
						<option value="Bachelors">Bachelors</option>
						<option value="Masters">Masters</option>
						<option value="Phd">PhD</option>
					</select>
					<hr>
					<label for="experienceLevel">Experience Level</label> <select
						name="experienceLevel" class="form-control" id="experienceLevel">
						<option value="1">0-3 years</option>
						<option value="2">3-5 years</option>
						<option value="3">5-10 years</option>
						<option value="4">10+ years</option>
					</select>
				</div>
			</div>


		</div>-->
		<!--/left-->

		<!--center-->
		<div class="col-sm-12">
			<c:forEach items="${jobs}" var="job">
				<div class="row">

					<div class="col-xs-12">
						<h2>${job.jobTitle}</h2>
						<h4><i class="glyphicon glyphicon-briefcase"></i>&nbsp;${job.companyName}</h4>
						<p>${job.jobDescription}</p>
						<p class="lead">
							<a class="btn btn-info" href="getJob/${job.jobID}">Learn More</a>
						</p>
						<p class="pull-right">
						<c:forEach items="${job.jobSkills}" var="skill">
							<span class="label label-default">${skill.skillName}</span>
						</c:forEach>
						</p>
						<ul class="list-inline">
							<li><a href="#"><i class="glyphicon glyphicon-calendar"></i> ${job.postedDate}</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-map-marker"></i>
									${job.location}</a></li>							
						</ul>
					</div>

				</div>
				<hr>
			</c:forEach>

		</div>
		<!--/center-->

	</div>
	<!--/container-fluid-->
</body>
</html>
