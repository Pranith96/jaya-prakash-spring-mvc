<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html"%>

<html>
<marquee width="100%" behavior="scroll" bgcolor="#00ffff">
	Community Portal Website </marquee>
<body bgcolor="#87ceff">
	<script>
		function validateform() {
			var email = document.myform.emailId.value;
			var password = document.myform.password.value;

			if (email == "") {
				alert("Email is Mandatory");
				return false;
			}

			if (password == "") {
				alert("Password is Mandatory");
				return false;
			}

		}
	</script>

	<h1>Login</h1>

	<form:form commandName="user"
		action="../../communityportal/user/login/check" method="post"
		onsubmit="return validateform()">
		<table>
			<tr>
				<td><label class="label">Email:</label></td>
				<td><form:input path="emailId"></form:input></td>
			</tr>
			<tr>
				<td><label class="label">password</label></td>
				<td><form:input type="password" path="password"></form:input></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit" /></td>
			</tr>
			<tr>
				<td><input type="reset" style="float: right"></input></td>
			</tr>
		</table>
	</form:form>
	<form align='left'
		action='http://localhost:8080/communityportal/user/password/reset'>
		<div align='left'>
			<input type='submit' value='Forgot password' />
		</div>
	</form>

</body>
</html>