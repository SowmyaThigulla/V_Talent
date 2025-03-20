package com.StudentProject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.StudentProject.bean.StudentBean;

import com.StudentProject.dao.StudentDao;

/**
 * Servlet implementation class Registrationservlet
 */
@WebServlet("/registrationservlet")
public class Registrationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registrationservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		@SuppressWarnings("unused")
		String Name = request.getParameter("Name");
		@SuppressWarnings("unused")
		String Mobileno = request.getParameter("Mobileno");
		@SuppressWarnings("unused")
		String Address = request.getParameter("Address");
		@SuppressWarnings("unused")
		String Email = request.getParameter("Email");
		@SuppressWarnings("unused")
		String Tech = request.getParameter("Tech");
		@SuppressWarnings("unused")
		String College = request.getParameter("College");

		StudentBean s = new StudentBean(); // As we need to use across the project creating the

		s.setName("Name");
		s.setMobileno("Mobileno");
		s.setAddress("Address");
		s.setEmail("Email");
		s.setTech("Tech");
		s.setCollege("College");

		@SuppressWarnings("unused")

		StudentDao rd = new StudentDao();
		int result = StudentDao.Insertdata(s); // we will have value for result

		HttpSession session = request.getSession(); // keeping the session open
		(session).setAttribute("StudentObject", s);

		RequestDispatcher Success = request.getRequestDispatcher("Success.html");
		RequestDispatcher Fail = request.getRequestDispatcher("Fail.html");

		if (result > 0) {
			Success.forward(request, response);
		} else {
			Fail.forward(request, response);
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}
