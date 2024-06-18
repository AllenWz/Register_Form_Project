<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<link rel="stylesheet" href="style2.css">
</head>
<body>
	<div class="container">
		<h1 class="header">Student Registration</h1>

		<form action="register" method="post">
			<div class="form-container">
				<div class="form-group">
					<label for="name">Full Name:</label> <input type="text"
						class="form-control" id="name" name="name" required>
				</div>
				<div class="form-group">
					<label for="email">Email:</label> <input type="email"
						class="form-control" id="email" name="email" required>
				</div>
				<div class="form-group">
					<label for="dob">Date of Birth:</label> <input type="date"
						class="form-control" id="dob" name="dob" required>
				</div>
				<div class="form-group">
					<label for="phone">Phone number:</label> <input type="text"
						class="form-control" id="phone" name="phone" required>
				</div>
				<div class="form-group">
					<label for="address">Address:</label>
					<textarea class="form-control" rows="1" id="address" name="address"
						required></textarea>
				</div>
				<div class="form-group">
					<label for="course">Course:</label> <select id="course"
						class="form-control" name="course" required>
						<option>N1</option>
						<option>N2</option>
						<option>N3</option>
						<option>N4</option>
						<option>N5</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label>Gender: </label>
				<div class="label-container">
					<label class="radio-inline"><input type="radio"
						name="gender" class="radio-btn" value="Male" required>
						Male</label> <label class="radio-inline"><input type="radio"
						name="gender" class="radio-btn" value="Female" required>
						Female</label>
				</div>
			</div>

			<div class="btn-container">
				<input type="submit" value="Register" class="btn btn-outline-success"> 
				<a href="showStudents" class="btn btn-outline-info">Show List</a>
			</div>

		</form>

	</div>
</body>
</html>