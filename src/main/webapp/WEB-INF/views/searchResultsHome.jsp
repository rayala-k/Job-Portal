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
					<li><a href="login.htm">Login</a></li>
					<li><a href="register.htm">Sign Up</a></li>
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
				<li><a href="/">Home</a></li>
			</ul>
		</div>
	</div>




	<div class="jumbotron jobSeekerSearchBar">
		<div class="container">
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
				<input type="hidden" value="check" name="check"/>
			</form>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2 class="text-center">Search Results</h2>
			</div>
			<div id="no-more-tables">
				<table class="col-sm-12 table-striped table-condensed cf">
					<thead class="cf">
						<tr>							
							<th>Title</th>
							<th>Company Name</th>
							<th>Location</th>
							<th>Posted Date</th>
							<th>Required Skills</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${jobs}" var="job">
							<tr>
								
								<td>${job.jobTitle}</td>
								<td>${job.companyName}</td>
								<td>${job.location}</td>
								<td>${job.postedDate}</td>
								<td><c:forEach items="${job.jobSkills}" var="skill">
										<span class="label label-primary">${skill.skillName}</span>
									</c:forEach></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
				<ul class="pagination">
					
						<%--For displaying Previous link except for the 1st page --%>
						<c:if test="${currentPage != 1}">
							<li><a href="searchFromHome.htm?page=${currentPage - 1}">Previous</a></li>
						</c:if>
						<c:forEach begin="1" end="${noOfPages}" var="i">
							<c:choose>
								<c:when test="${currentPage eq i}">
									<li><a href="#">${i}</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="searchFromHome.htm?page=${i}">${i}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<%--For displaying Next link --%>
						<c:if test="${currentPage lt noOfPages}">
							<li><a href="searchFromHome.htm?page=${currentPage + 1}">Next</a></li>
						</c:if>				
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
