package FirstMavenProject.web.controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "jdbc:mysql://localhost:3306/javaeestudents";
		String username = "root";
		String password = "root";


		String name = "name";
		String pass = "pass";
		
		if (!request.getParameter("name").equals(name) || !request.getParameter("password").equals(pass) ) {
			
			request.setAttribute("result", "fail");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);			
		}
		else {
			// this is not where you're supposed to do this
			try  {
			    
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection(url, username, password);
	            
				PreparedStatement stmt= conn.prepareStatement("insert into simplestudents (name, pass) values(?,?)");
	
				stmt.setString(1, name);
				stmt.setString(2,pass);
		
				stmt.executeUpdate();
				
			    conn.close();
			    
			} catch (SQLException e) {
				request.setAttribute("result", "fail");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				
				e.printStackTrace();

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("result", "success");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

}
