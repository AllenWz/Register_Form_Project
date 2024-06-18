package com.allen.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allen.Student;
import com.allen.dao.StudentDao;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get id value from parameter of edit button
		int id = Integer.parseInt(req.getParameter("id"));
		//connect with database and take corresponding data to edit
		StudentDao dao = new StudentDao();
		Student std = dao.selectStudent(id);
		//set attribute and send data to JSP page
		req.setAttribute("student", std);
		RequestDispatcher rd =  req.getRequestDispatcher("edit.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
