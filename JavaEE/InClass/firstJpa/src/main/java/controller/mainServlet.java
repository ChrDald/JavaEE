package controller;

import dao.*;
import model.student;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mainServlet
 */
public class mainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		punit1dao dao = new punit1dao();
		
		if (request.getParameter("studentId") != null) {
			
			int id = Integer.parseInt(request.getParameter("studentId").toString());
			
			//dao.updateStudentById(id);
			//dao.getStudentById(id);
			
			request.setAttribute("student", dao.getStudentById(id));
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// adding a new student 
		
		String name = request.getParameter("name").toString();
		String pass = request.getParameter("pass").toString();
		
		
		punit1dao dao = new punit1dao();
		dao.addNewStudent(name, pass);
		
		request.setAttribute("result", "success");
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.include(request, response);
	}

}
