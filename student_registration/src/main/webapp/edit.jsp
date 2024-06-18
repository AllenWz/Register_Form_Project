<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.allen.Student"%>
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
<link rel="stylesheet" href="edit.css">
</head>

<body>

	<%
	Student std = (Student) request.getAttribute("student");
	%>

	<div class="table-responsive">
		<form action="update">
			<table class="table table-hover">
				<tr>
					<td>Id</td>
					<td><input readonly type="text" name="id" value="<%=std.id()%>"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" value="<%=std.name()%>"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" value="<%=std.email()%>"></td>
				</tr>
				<tr>
					<td>DOB</td>
					<td><input type="text" name="dob" value="<%=std.dob()%>"></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><input type="text" name="phone" value="<%=std.phone()%>"></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address"
						value="<%=std.address()%>"></td>
				</tr>
				<tr>
					<td>Course</td>
					<td><select id="course" class="form-control" name="course">
							<option>N1</option>
							<option>N2</option>
							<option>N3</option>
							<option>N4</option>
							<option>N5</option>
					</select></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><div class="label-container">
							<label class="radio-inline"><input type="radio"
								name="gender" class="radio-btn" value="Male"> Male</label> <label
								class="radio-inline"><input type="radio" name="gender"
								class="radio-btn" value="Female" required> Female</label>
						</div></td>
				</tr>
				<tr>
					<td><input type="submit" class="btn btn-outline-primary" value="Confirm"></td>
					<td><a href="home.jsp" class="btn btn-outline-success">Home</a></td>
				</tr>
			</table>
		</form>
	</div>


</body>
</html>