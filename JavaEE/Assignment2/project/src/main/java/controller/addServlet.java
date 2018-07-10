package controller;

import dao.*;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addServlet
 */
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("addProduct.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			productDAO dao = new productDAO();
			
			String productPrice = request.getParameter("productPrice");
			String productName = request.getParameter("productName");
			
			try {
				double doublePrice = Double.parseDouble(productPrice);
				BigDecimal price = BigDecimal.valueOf(doublePrice);
				
				dao.addNewProduct(productName, price);
				RequestDispatcher rd = request.getRequestDispatcher("addProduct.jsp");
				request.setAttribute("status", "New Product Added Successfully");
				rd.include(request, response);
			}
			catch (Exception e) {
				RequestDispatcher rd = request.getRequestDispatcher("addProduct.jsp");
				request.setAttribute("status", "Invalid Product Price");
				rd.include(request, response);
			}
			
	}

}
