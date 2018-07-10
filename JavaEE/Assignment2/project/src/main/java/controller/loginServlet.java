package controller;

import dao.*;
import model.user;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.removeAttribute("currentUser");

		session.invalidate();
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		userDao dao = new userDao();
		
		user u = dao.getUser(username);
				
		if (u != null && password.equals(u.getPassword())) {
			
			request.setAttribute("username", username);
			request.setAttribute("user", u);
			
			// initialize session 
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", username);

			// this should probably check a user role value in the database instead of the actual name, thats dumb
			// but time constraints.
			if (u.getUsername().equals("admin")) {
				session.setAttribute("role", "admin");
				request.setAttribute("userRole", "admin");
								
			}
			else {
				session.setAttribute("role", "user");
				request.setAttribute("userRole", "user");
			}
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
			//response.sendRedirect("welcome.jsp");
		}
		else {
			
			request.setAttribute("error", "Wrong username or password.");

			response.sendRedirect("index.jsp");
		}
	}

}
