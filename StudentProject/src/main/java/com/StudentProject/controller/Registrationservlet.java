package com.StudentProject.controller;

import java.io.IOException;

import Bean.Student;
import Dao.registrationdao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class registrationservlet
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		Student s = new Student(); //As we need to use across the project creating the

		s.setName("Name");
		s.setMobileno("Mobileno");
		s.setAddress ("Address");
		s.setEmail("Email");
		s.setTech("Tech");
		s.setCollege("College");
		
		@SuppressWarnings("unused")
		registrationdao rd = new registrationdao();
		int result = registrationdao.Insertsata(s); //we will have value for result
		HttpSession session = request.getSession(); // keeping the session open
		(session).setAttribute("StudentObject",s);
		
		RequestDispatcher Success = request.getRequestDispatcher("Success.html");
		RequestDispatcher Fail = request.getRequestDispatcher("Fail.html");
		

		if(result>0) {
			Success.forward(request, response);
		}
		else {
			Fail.forward(request, response);
		}


		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}
	
	

}
