<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.allen.Student"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet" href="list.css">
</head>
<body>

	<%
	ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("list");
	%>
	<div class="container">
		<h2 class="header">Students Data</h2>
		<div class="table-responsive">
			<table class="table table-hover table-striped">

				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Date of Birth</th>
					<th>Phone</th>
					<th>Address</th>
					<th>Course</th>
					<th>Gender</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<%
				for (Student s : students) {
				%>

				<tr>
					<td><%=s.id()%></td>
					<td><%=s.name()%></td>
					<td><%=s.email()%></td>
					<td><%=s.dob()%></td>
					<td><%=s.phone()%></td>
					<td><%=s.address()%></td>
					<td><%=s.course()%></td>
					<td><%=s.gender()%></td>
					<td><a href="edit?id=<%= s.id()%>"><button class="btn btn-primary">Edit</button></a></td>
					<td><a href="delete?id=<%= s.id()%>"><button class="btn btn-danger">Delete</button></a></td>
				</tr>

				<%
				}
				%>

			</table>
		</div>
		<a href="home.jsp"><button class="btn btn-outline-success btnHome">Home</button></a>

	</div>
</body>
</html>