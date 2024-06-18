package com.allen.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allen.Student;
import com.allen.dao.StudentDao;

@WebServlet("/update")
public class updateStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dob = LocalDate.parse(req.getParameter("dob"), formatter);
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String course = req.getParameter("course");
		String gender = req.getParameter("gender");

		Student std = new Student(id, name, email, dob, phone, address, course, gender);
		StudentDao dao = new StudentDao();
		int count = dao.updateStudentData(std);

		if (count == 1) {
			out.println("<h2>Update Data Successfully</h2>");
			out.println("<a href='home.jsp'>Home</a><br>");
			out.println("<a href='showStudents'>Show List</a>");
		} else {
			out.println("<h2>Opps! something went wrong</h2>");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
