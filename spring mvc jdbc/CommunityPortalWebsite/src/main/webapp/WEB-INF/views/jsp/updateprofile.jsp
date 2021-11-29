<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html"%>

<html>
<marquee width="100%" behavior="scroll" bgcolor="#00ffff">
	Community Portal Website </marquee>
<head>

<title>Update Profile</title>
</head>
<body bgcolor="#87ceff">
	<script>
		function validateform() {
			var firstName = document.myform.firstName.value;
			var lastName = document.myform.lastName.value;
			var mobileNumber = document.myform.mobileNumber.value;
			var email = document.myform.emailId.value;

			if (firstName == "") {
				alert("First Name is Mandatory");
				return false;
			}

			if (lastName == "") {
				alert("Last Name is Mandatory");
				return false;
			}

			if (mobileNumber == "") {
				alert("Mobile Number is Mandatory");
				return false;
			}

			if (email == "") {
				alert("Email is Mandatory");
				return false;
			}
		}
	</script>

	<form align='center'
		action='http://localhost:8080/communityportal/user/redirect/home'>
		<div align='center'>
			<input type='submit' value='Home' />
		</div>
	</form>

	<form align='center'
		action='http://localhost:8080/communityportal/user/get/profile/${userId}'>
		<div align='center'>
			<input type='submit' value='Profile' />
		</div>
	</form>

	<form align='center'
		action='http://localhost:8080/communityportal/user/login'>
		<div align='center'>
			<input type='submit' value='Logout' />
		</div>
	</form>

	<h3 style="text-align: center">User Details Update Form</h3>

	<table align="center">

		<form:form commandName="user" name="myform"
			action="../../communityportal/user/update/check" method="post"
			onsubmit="return validateform()">

			<tr>
				<td><label>First Name:</label></td>
				<td><form:input path="firstName"></form:input></td>
			</tr>

			<tr>
				<td><label>Last Name:</label></td>
				<td><form:input path="lastName"></form:input></td>
			</tr>
			<tr>
				<td><label>Mobile Number:</label></td>
				<td><form:input path="mobileNumber"></form:input></td>
			</tr>

			<tr>
				<td><label>Email:</label></td>
				<td><form:input path="emailId"
						placeholder="Email Id cannot be updated Enter Existing mail id"></form:input></td>
			</tr>

			<tr>
				<td><form:label path="gender">Gender</form:label></td>
				<td><form:radiobutton path="gender" value="MALE" label="MALE" />
					<form:radiobutton path="gender" value="FEMALE" label="FEMALE" /></td>
			</tr>

			<tr>
				<td><label>Company Name:</label></td>
				<td><form:input path="companyName"></form:input></td>
			</tr>

			<tr>
				<td><label><b>Address Details: </b></label>
			<tr>
				<td><label>Plot No:</label></td>
				<td><form:input path="plotNo"></form:input></td>
			</tr>

			<tr>
				<td><label>Street No:</label></td>
				<td><form:input path="streeNo"></form:input></td>
			</tr>

			<tr>
				<td><label>Locality:</label></td>
				<td><form:input path="colonyName"></form:input></td>
			</tr>

			<tr>
				<td><label>City:</label></td>
				<td><form:input path="city"></form:input></td>
			</tr>

			<tr>
				<td><label>State:</label></td>
				<td><form:input path="state"></form:input></td>
			</tr>

			<tr>
				<td><label>Country:</label></td>
				<td><form:input path="country"></form:input></td>
			</tr>

			<tr>
				<td><input type="submit" style="float: right"></input></td>
			</tr>
			<tr>
				<td><input type="reset" style="float: right"></input></td>
			</tr>
		</form:form>
	</table>


</body>
</html>