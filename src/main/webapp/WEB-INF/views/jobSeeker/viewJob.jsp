<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>View Job - Job Seeker</title>

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
	background-color: #f6f6f6;
	background-position: center -320px;
	border-bottom: 1px solid #e9e9e9;
	margin: -30px 0px 20px 0px;
	padding: 38px 0px;
}

.jobSeekerSearchBar {
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
				<li><a
					href="${pageContext.request.contextPath}/jobSeekerHome.htm">Home</a></li>
				<li><a href="#">Profile</a></li>
				<li><a
					href="${pageContext.request.contextPath}/availableJobs.htm">Available
						Jobs</a></li>
			</ul>
		</div>
	</div>

	<div class="document-title">
		<div class="container">
			<div class="row">
				<div class="col-sm-9">
					<h2>${job.companyName}</h2>
					<h3>${job.jobTitle}
						<span class="label label-info">${job.jobType}</span>
					</h3>
				</div>
				<div class="col-sm-3">
					<c:if test="${empty applied}">
						<h3>
							<a class="btn btn-primary"
								href="${pageContext.request.contextPath}/applyJob/${job.jobID}.htm">Apply
								for Job</a>
						</h3>
					</c:if>
					<c:if test="${not empty applied}">
						<h3>
							<button class="btn btn-primary" disabled="disabled">Apply for Job</button>
						</h3>
					</c:if>
				</div>
			</div>
		</div>
		<!-- /.container -->
	</div>

	<div class="container">

		<!--center-->
		<div class="col-sm-9">
			<div class="row">
				<div class="col-xs-12">
					<h4>Job Description:</h4>
					<p>${job.jobDescription}</p>
					<hr>
					<h4>Requirements:</h4>
					<p>${job.jobRequirements}</p>
					<hr>
					<h3>Skills</h3>
					<p class="pull-left">
						<c:forEach items="${job.jobSkills}" var="skill">
							<span class="label label-info">${skill.skillName}</span>
						</c:forEach>
					</p>
				</div>
			</div>
			<hr>
		</div>
		<!--/center-->

		<!--right-->
		<div class="col-sm-3">
			<h3>Job Overview</h3>
			<div class="panel panel-default">
				<div class="panel-body">
					<h4 style="color: #337ab7">
						<i class="glyphicon glyphicon-calendar"></i> Date Posted:
					</h4>
					${job.postedDate}
					<h4 style="color: #337ab7">
						<i class="glyphicon glyphicon-map-marker"></i> Location:
					</h4>
					${job.location}
					<h4 style="color: #337ab7">
						<i class="glyphicon glyphicon-education"></i> Education:
					</h4>
					${job.educationRequirements}
				</div>
			</div>
		</div>
		<!--/right-->
		<hr>
	</div>
	<!--/container-fluid-->
</body>
</html>
