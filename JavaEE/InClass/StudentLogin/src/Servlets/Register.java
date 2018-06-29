package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

import Models.Student;
import java.sql.*;  
/**
 * Servlet implementation class Register
 */
@WebServlet("/register3")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("registerNew.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String studentName = request.getParameter("studentname");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		
		Student student = new Student();
		student.setStudentName(studentName);
		student.setUserName(userName);
		student.setPassword(password);
		student.setEmail(email);
		student.setCity(city);
				
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/javaeestudents","root","root");  
			
			
			PreparedStatement stmt = con.prepareStatement("INSERT INTO students (name, password, email, city) VALUES(?,?,?,?)"); 
			
			stmt.setString(1, student.getStudentName());
			stmt.setString(2, student.getUserName());
			stmt.setString(3, student.getPassword());
			stmt.setString(4, student.getCity());

			stmt.executeUpdate();
			 
			
			con.close();  
			
			request.setAttribute("result", "ok");
			RequestDispatcher rd = request.getRequestDispatcher("RegisterResult.jsp");
			rd.forward(request, response);
		}
		catch(Exception e){ 
			System.out.println(e);
		}  
	}

}
