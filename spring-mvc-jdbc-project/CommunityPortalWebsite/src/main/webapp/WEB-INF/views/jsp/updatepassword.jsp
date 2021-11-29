<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html"%>

<html>
<marquee width="100%" behavior="scroll" bgcolor="#00ffff">
	Community Portal Website </marquee>
<head>

<title>Password reset</title>
</head>
<body bgcolor="#FAF0E6">
	<h2 style="text-align: left;">Password Update</h2>

	<table align="left">
		<form:form commandName="user" name="myform"
			action="../../user/update/password" method="post">

			<tr>
				<td><label>Enter Registered Email:</label></td>
				<td><form:input path="emailId"></form:input></td>
			</tr>

			<tr>
				<td><label>Enter New Password:</label></td>
				<td><form:input type ="password" path="password"></form:input></td>
			</tr>

			<tr>
				<td><input type="submit" style="float: right"></input></td>
			</tr>
		</form:form>
	</table>

	<form align='left'
		action='http://localhost:8080/communityportal/user/redirect/home'>
		<div align='left'>
			<input type='submit' value='Home' />
		</div>
	</form>

</body>
</html>