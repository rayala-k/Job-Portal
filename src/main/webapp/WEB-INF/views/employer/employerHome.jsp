<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Home - Employer</title>

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

@media only screen and (max-width: 800px) {
	/* Force table to not be like tables anymore */
	#no-more-tables table, #no-more-tables thead, #no-more-tables tbody,
		#no-more-tables th, #no-more-tables td, #no-more-tables tr {
		display: block;
	}

	/* Hide table headers (but not display: none;, for accessibility) */
	#no-more-tables thead tr {
		position: absolute;
		top: -9999px;
		left: -9999px;
	}
	#no-more-tables tr {
		border: 1px solid #ccc;
	}
	#no-more-tables td {
		/* Behave like a "row" */
		border: none;
		border-bottom: 1px solid #eee;
		position: relative;
		padding-left: 50%;
		white-space: normal;
		text-align: left;
	}
	#no-more-tables td:before {
		/* Now like a table header */
		position: absolute;
		/* Top/left values mimic padding */
		top: 6px;
		left: 6px;
		width: 45%;
		padding-right: 10px;
		white-space: nowrap;
		text-align: left;
		font-weight: bold;
	}
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
				<li class="active"><a href="employerHome.htm">Home</a></li>
				<li><a href="addJob.htm">Post a Job</a></li>
			</ul>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2 class="text-center">My Job Listings</h2>
			</div>
			<div id="no-more-tables">
				<table
					class="col-sm-12 table-striped table-condensed cf">
					<thead class="cf">
						<tr>
							<th>Job ID</th>
							<th>Title</th>
							<th>Open?</th>
							<th>Posted Date</th>
							<th>Number of Applicants</th>
							<th>View Applications</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${sessionScope.person.postedJobs}" var="job">
							<tr>
								<td>${job.jobID}</td>
								<td><a href="${pageContext.request.contextPath}/viewJob/${job.jobID}">${job.jobTitle}</a></td>
								<td>${job.active}</td>
								<td>${job.postedDate}</td>
								<td>${job.appliedJobs.size()}</td>
								
								<td><a href="viewApplicants/${job.jobID}">View Applicants</a></td>								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>
