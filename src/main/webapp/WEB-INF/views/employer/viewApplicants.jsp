<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>View Applicants - Employer</title>

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
					<li><a href="${pageContext.request.contextPath}/logout.htm">Logout</a></li>
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
					href="${pageContext.request.contextPath}/employerHome.htm">Home</a></li>
				<li><a href="${pageContext.request.contextPath}/addJob.htm">Post
						a Job</a></li>
			</ul>
		</div>
	</div>

	<div class="document-title">
		<div class="container">
			<div class="row">
				<div class="col-sm-9">
					<h2 id="jobID" style="display: none;">${job.jobID}</h2>
					<h2>${job.companyName}</h2>
					<h3>${job.jobTitle}
						<span class="label label-info">${job.jobType}</span>
					</h3>
					<p class="pull-right">
						<c:forEach items="${job.jobSkills}" var="skill">
							<span class="label label-primary">${skill.skillName}</span>
						</c:forEach>
					</p>
					<ul class="list-inline">
						<li><a href="#"><i class="glyphicon glyphicon-calendar"></i>${job.postedDate}</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-map-marker"></i>
								${job.location}</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-education"></i>
								${job.educationRequirements}</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- /.container -->
	</div>

	<div class="container-fluid">

		<!--left-->
		<div class="col-sm-3">
			<h2>Filter Results</h2>
			<div class="panel panel-default">
				<div class="panel-body">
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
					<hr>
					<label for="statusFilter">Update Status</label> <select
						name="statusFilter" class="form-control" id="statusFilter">
						<option value="New">New</option>
						<option value="In Process">In Process</option>
						<option value="Not Selected">Not Selected</option>
						<option value="Hired">Hired</option>
					</select>
				</div>
			</div>


		</div>
		<!--/left-->

		<!--center-->
		<div class="col-sm-9">
			<c:forEach items="${applicants}" var="applicant">
				<div class="row">

					<div class="col-xs-12">
						<h2>${applicant.jobSeeker.firstName}&nbsp;${applicant.jobSeeker.lastName}</h2>
						<p>
							<span class="pull-left">${applicant.jobSeeker.resume.jobTitle}</span>
							<span class="label label-success pull-right"
								id="${applicant.jobSeeker.personID}">${applicant.status}</span>
						</p>
						<br />
						<p>
							<span class="pull-left">${applicant.jobSeeker.email}</span>
						</p>
						<p>
							<c:forEach items="${applicant.jobSeeker.resume.mySkills}"
								var="skill">
								<span class="label label-default">${skill.skillName}</span>
							</c:forEach>
						</p>
						<p>
							<a
								href="${pageContext.request.contextPath}/download/${applicant.jobSeeker.resume.resumeID}.html">
								Download Resume</a>
						</p>
						<br />
						<ul class="list-inline">

							<li><select name="status" class="form-control" id="status">
									<option value="In Process">In Process</option>
									<option value="Not Selected">Not Selected</option>
									<option value="Hired">Hired</option>
							</select> <input type="hidden" name="applicantID"
								value="${applicant.jobSeeker.personID}"></li>
							<c:if test="${job.active}">
								<li><a class="btn btn-info updateStatus" href="#">Update
										Status</a></li>
							</c:if>
						</ul>
					</div>
				</div>
				<hr>
			</c:forEach>

		</div>
		<!--/center-->

	</div>
	<!--/container-fluid-->

	<script>
		$(document)
				.ready(
						function() {
							$(".updateStatus")
									.click(
											function() {
												var jobID = $("#jobID").text();

												var status = $(this).parent()
														.siblings().find(
																"select").val();

												var applicantID = $(this)
														.parent().siblings()
														.find("input").val();

												$
														.ajax({
															type : "POST",
															url : "${pageContext.request.contextPath}/updateStatus.htm",
															data : {
																id : jobID,
																jobStatus : status,
																jobSeekerID : applicantID
															},
															success : function(
																	response) {
																alert("success");
																$(
																		"#"
																				+ applicantID)
																		.text(
																				status);
															},
															error : function(
																	XMLHttpRequest,
																	textStatus,
																	errorThrown) {
																alert("Status: "
																		+ textStatus);
																alert("Error: "
																		+ XMLHttpRequest.responseText);
															}
														});
											})
						});
	</script>
</body>
</html>
