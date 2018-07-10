package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculateServlet
 */
public class CalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// extra validation
		if (request.getParameter("first") != null && request.getParameter("second") != null) {
			
		
			try {
				double firstNumber = Double.parseDouble(request.getParameter("first"));
				double secondNumber = Double.parseDouble(request.getParameter("second"));
				
				// make sure the user selected an operation and calculate
				if (request.getParameter("operation") != null) {
					
					if (request.getParameter("operation").equals("add")) {
						request.setAttribute("result", (firstNumber + secondNumber));
					}
					else if (request.getParameter("operation").equals("sub")) {
						request.setAttribute("result", (firstNumber - secondNumber));
					}
					else if (request.getParameter("operation").equals("mul")) {
						request.setAttribute("result", (firstNumber * secondNumber));
					}
					else if (request.getParameter("operation").equals("div")) {
						request.setAttribute("result", (firstNumber / secondNumber));
					}
					else throw new Exception();
					
					RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
					rd.forward(request, response);
				}
			}
			catch (Exception e) {
				request.setAttribute("error", "Invalid Numbers entered");
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.include(request, response);
			}
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
