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
				<li class="active"><a href="jobSeerkerHome.htm">Home</a></li>
				<li><a href="#">Profile</a></li>
			</ul>
		</div>
	</div>

	<div class="document-title">
		<div class="container">
			<h1 class="center">Create Profile</h1>
		</div>
		<!-- /.container -->
	</div>


	<div class="container">
		<form role="form" id="resume-form" method="post" enctype="multipart/form-data"
			action="saveResume.htm">

			<div class="row">
				<div class="form-group col-xs-6 col-lg-6">
					<label for="jobTitle">Job Title</label> <input
						type="text" class="form-control" id="jobTitle"
						name="jobTitle" />
				</div>
			</div>
			
			
			<div class="row">
				<div class="form-group col-xs-6 col-lg-6">
					<label for="totalExperience">Total Experience in Years</label> <input
						type="number" class="form-control" id="totalExperience"
						name="totalExperience" />
				</div>
			</div>

			<div class="row">
				<div class="form-group col-xs-6 col-lg-6">
					<label for="highestEducationLevel">Highest Education Level</label>
					<select name="highestEducationLevel" class="form-control"
						id="highestEducationLevel">
						<option value="Bachelors">Bachelors</option>
						<option value="Masters">Masters</option>
						<option value="Phd">PhD</option>
					</select>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-lg-3">
					<label for="gpa">Skill</label> <input type="text"
						class="form-control" id="skill" name="skill" /> <a
						class="btn btn-info pull-right customBtn" id="addSkill">Add
						Skill</a>
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


			<div class="row">
				<div class="form-group col-xs-6 col-lg-6">
					<label for="file">Upload Resume</label> <input
						type="file" name="file" id="file"></input>
				</div>
			</div>

			<hr />




			<br>

			<div class="row">

				<button type="submit" class="btn btn-primary">Create Profile</button>
			</div>
		</form>


	</div>
</body>
</html>
