

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputCheck
 */
@WebServlet("/InputCheck")
public class InputCheck extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String result;
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String usernameCheck = request.getParameter("usernameCheck");
		String passwordCheck = request.getParameter("passwordCheck");
		
		if (username.equals(usernameCheck) && password.equals(passwordCheck)) {
			result = "Success <br />Username: " + username + " Password: " + password;
		}
		else {
			result = "Inputs do not match";
		}
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.write("<html><body><h1>" + result + "</h1></body></html>");
	}

}
