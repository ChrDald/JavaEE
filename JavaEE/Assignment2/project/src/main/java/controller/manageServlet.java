package controller;

import dao.*;
import model.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class manageServlet
 */
public class manageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		productDAO dao = new productDAO();
		
		ArrayList<product> list = dao.getAllProducts();
		
		request.setAttribute("products", list);
		
		HttpSession session = request.getSession();

		if (session.getAttribute("role") != null && session.getAttribute("role").equals("admin")) {
			request.setAttribute("userRole", "admin"); 
		}
		else {
			request.setAttribute("userRole", "user"); 
		}

		
		
		//request.setAttribute("userRole", "admin");  // this is only accessible by admins
		// make a seperate page instead of including on the welcome page
		
		RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
