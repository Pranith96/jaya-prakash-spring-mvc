<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Portal Website Details</title>

<style>
* {
	margin: 0;
	padding: 0;
}

.navbar {
	display: flex;
	align-items: center;
	justify-content: center;
	position: sticky;
	top: 0;
	cursor: pointer;
}

.background {
	background: black;
	background-blend-mode: darken;
	background-size: cover;
}

.nav-list {
	width: 70%;
	display: flex;
	align-items: center;
}

.nav-list li {
	list-style: none;
	padding: 26px 30px;
}

.nav-list li a {
	text-decoration: none;
	color: white;
}

.nav-list li a:hover {
	color: grey;
}

.rightnav {
	width: 30%;
	text-align: right;
}

#search {
	padding: 5px;
	font-size: 17px;
	border: 2px solid grey;
	border-radius: 9px;
}

.firstsection {
	background-color: #FFF8DC;
	height: 605px;
}

.box-main {
	display: flex;
	justify-content: center;
	align-items: center;
	color: black;
	max-width: 80%;
	margin: auto;
	height: 80%;
}

.firsthalf {
	width: 100%;
	display: flex;
	flex-direction: column;
	justify-content: center;
}

.text-big {
	font-family: 'Piazzolla', serif;
	font-weight: bold;
	font-size: 35px;
}

.text-small {
	font-size: 18px;
}

.btn {
	padding: 8px 20px;
	margin: 7px 0;
	border: 2px solid white;
	border-radius: 8px;
	background: none;
	color: white;
	cursor: pointer;
}

.btn-sm {
	padding: 6px 10px;
	vertical-align: middle;
}

.section {
	height: 400px;
	display: flex;
	align-items: center;
	justify-content: center;
	max-width: 90%;
	margin: auto;
}

.center {
	text-align: center;
}

.text-footer {
	text-align: center;
	padding: 30px 0;
	font-family: 'Ubuntu', sans-serif;
	display: flex;
	justify-content: center;
	color: white;
}
</style>
</head>
<body>
	<nav class="navbar background">
		<ul class="nav-list">
			<li><a
				href="http://localhost:8080/communityportal/user/redirect/home">Home</a></li>
			<li><a
				href="http://localhost:8080/communityportal/user/get/profile/${userId}">Profile</a></li>
			<li><a href="http://localhost:8080/communityportal/user">Logout</a></li>
		</ul>

		<div class="rightNav">
			<input type="text" name="search" id="search">
			<button class="btn btn-sm">Search</button>
		</div>
	</nav>

	<section class="firstsection">
		<div class="box-main">
			<div class="firstHalf">
				<h1 class="text-big" id="vision">Our Culture:</h1>
				<p class="text-small">Our Culture in company, we are constantly
					iterating, solving problems and working together to connect people
					all over the world. That's why it's important that our workforce
					reflects the diversity of the people we serve. Hiring people with
					different backgrounds and points of view helps us make better
					decisions, build better products and create better experiences for
					everyone.</p>
			</div>
		</div>
	</section>

	<footer class="background">
		<p class="text-footer">Copyright ©-All rights are reserved</p>
	</footer>
</body>
</html>