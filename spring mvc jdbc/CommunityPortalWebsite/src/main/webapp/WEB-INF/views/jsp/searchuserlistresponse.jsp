<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.wdf.springmvc.model.User"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<body bgcolor="#FAF0E6">
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

	<h3 align="center">Search result</h3>

	<table align="center" border="1" width="50%">
		<tr>
			<th>USER Profile View</th>
			<th>FIRST NAME</th>
			<th>EMAIL ID</th>
			<th>Company Name</th>
		</tr>

		<c:forEach var="x" items="${userlist}">
			<tr>
				<td><a
					href="<c:url value='http://localhost:8080/communityportal/user/view/profile/${x.getUserId()}'/>">View
						Profile</a></td>
				<td><c:out value="${x.getFirstName()}" /></td>
				<td><c:out value="${x.getEmailId()}" /></td>
				<td><c:out value="${x.getCompanyName()}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

