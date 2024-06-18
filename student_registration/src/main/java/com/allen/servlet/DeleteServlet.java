package com.allen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allen.dao.StudentDao;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		int id = Integer.parseInt(req.getParameter("id"));
		
		StudentDao dao = new StudentDao();
		int count = dao.deleteStudent(id);
		if(count==1) {
			out.println("<h2>Record Deleted Successfully</h2>");
			out.println("<a href='home.jsp'>Home</a><br>");
			out.println("<a href='showStudents'>Show List</a>");
		}else {
			out.println("<h2>Opps! something went wrong</h2>");
		}
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
