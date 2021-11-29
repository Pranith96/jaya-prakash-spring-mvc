<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.wdf.springmvc.model.User"%>

<html>
<marquee width="100%" behavior="scroll" bgcolor="#00ffff">
	Community Portal Website </marquee>
<head>

<title>Profile</title>
</head>
<body bgcolor="#87ceff">
	<form align='center'
		action='http://localhost:8080/communityportal/user/redirect/home'>
		<div align='center'>
			<input type='submit' value='Home' />
		</div>
	</form>

	<form align='center'
		action='http://localhost:8080/communityportal/user/login'>
		<div align='center'>
			<input type='submit' value='Logout' />
		</div>
	</form>

	<h3 style="text-align: center;">User Profile</h3>

	<table align="center">
		<tr>
			<th width="30%">First Name</th>
			<td width="2%">:</td>
			<td><c:out value="${user.getFirstName()}" /></td>
		</tr>

		<tr>
			<th width="30%">Last Name</th>
			<td width="2%">:</td>
			<td><c:out value="${user.getLastName()}" /></td>
		</tr>

		<tr>
			<th width="30%">Gender</th>
			<td width="2%">:</td>
			<td><c:out value="${user.getGender()}" /></td>
		</tr>
		<tr>
			<th width="30%">Mobile Number</th>
			<td width="2%">:</td>
			<td><c:out value="${user.getMobileNumber()}" /></td>
		</tr>

		<tr>
			<th width="30%">Email</th>
			<td width="2%">:</td>
			<td>${user.emailId}</td>
		</tr>

		<tr>
			<th width="30%">Company Name</th>
			<td width="2%">:</td>
			<td>${user.companyName}</td>
		</tr>

		<tr>
			<td><label><b>Address Details: </b></label>
		<tr>
			<th width="30%">Plot No</th>
			<td width="2%">:</td>
			<td>${user.plotNo}</td>
		</tr>

		<tr>
			<th width="30%">Street No</th>
			<td width="2%">:</td>
			<td>${user.streeNo}</td>
		</tr>

		<tr>
			<th width="30%">Locality</th>
			<td width="2%">:</td>
			<td>${user.colonyName}</td>
		</tr>

		<tr>
			<th width="30%">City</th>
			<td width="2%">:</td>
			<td>${user.city}</td>
		</tr>

		<tr>
			<th width="30%">State</th>
			<td width="2%">:</td>
			<td>${user.state}</td>
		</tr>

		<tr>
			<th width="30%">Country</th>
			<td width="2%">:</td>
			<td>${user.country}</td>
		</tr>
	</table>

</body>
</html>