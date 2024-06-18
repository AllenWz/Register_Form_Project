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

import com.allen.dao.StudentDao;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw = resp.getWriter();
		//get the values
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dob = LocalDate.parse(req.getParameter("dob"),formatter);
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String course = req.getParameter("course");
		String gender = req.getParameter("gender");
		
		//create StudentDao and insert to data base
		StudentDao dao = new StudentDao();
		int count = dao.createStudent(name, email, dob, phone, address, course, gender);
		
		if(count==1) {
			resp.sendRedirect("welcome.jsp");
		}else {
			pw.println("<h2>Something Went Wrong Please Try Again!</h2>");
		}
	}
	
}
