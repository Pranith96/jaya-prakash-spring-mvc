<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html"%>

<html>
<marquee width="100%" behavior="scroll" bgcolor="#00ffff">
	Community Portal Website </marquee>
<head>

<title>Password reset</title>
</head>
<body bgcolor="#87ceff">
	<h2 style="text-align: left;">Password Reset</h2>

	<table align="left">
		<form:form commandName="user" action="../../user/forgotPassword"
			method="get">

			<tr>
				<td><label>Enter Registered Email:</label></td>
				<td><form:input path="emailId" name="emailId"></form:input></td>
			</tr>

			<tr>
				<td><input type="submit" style="float: right"></input></td>
			</tr>
		</form:form>
	</table>
	
	<form align='center'
		action='http://localhost:8080/communityportal/user/home'>
		<div align='center'>
			<input type='submit' value='Home' />
		</div>
	</form>

</body>
</html>