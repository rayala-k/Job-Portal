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
				<li class="active"><a href="jobSeekerHome.htm">Home</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="availableJobs.htm">Available Jobs</a></li>
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
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<h2>${sessionScope.person.firstName}</h2>
			</div>
			<div class="col-md-3">
				<c:if test="${empty sessionScope.person.resume}">
					<a href="resume.htm" class="btn btn-default btn-lg marginTop10"
						id="profileEditButton"> <span
						class="glyphicon glyphicon-pencil pull-left" id="profileIcon"></span>
						Create profile
					</a>
				</c:if>
				<c:if test="${not empty sessionScope.person.resume}">
					<a href="editResume.htm" class="btn btn-default btn-lg marginTop10"
						id="profileEditButton"> <span
						class="glyphicon glyphicon-pencil pull-left" id="profileIcon"></span>
						Edit profile
					</a>
				</c:if>
			</div>
		</div>
		<hr />
		<div class="row">
			<div class="col-md-3">
				<h4>${sessionScope.person.email}<i
						class="fa fa-envelope-o pull-left"></i>
				</h4>
			</div>
			<div class="col-md-3">
				<h4>${sessionScope.person.mobileNumber}<i
						class="fa fa-phone pull-left"></i>
				</h4>
			</div>
			<div class="col-md-3"></div>
		</div>
		<hr />
		
		<c:if test="${not empty sessionScope.person.resume}">
			<div class="row">
				<div class="col-md-3">
					<h4>Resume</h4>
				</div>
				<div class="col-md-3">
					<h4>
						<a
							href="${pageContext.request.contextPath}/download/${sessionScope.person.resume.resumeID}.html">
							Download </a>
					</h4>
				</div>
				<div class="col-md-3"></div>
			</div>
		</c:if>
	</div>
</body>
</html>
