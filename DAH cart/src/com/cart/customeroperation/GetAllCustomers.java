package com.cart.customeroperation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.dao.CustomerDAO;
import com.cart.dao.CustomerDAOImpl;

@WebServlet("/GetAllCustomers")
public class GetAllCustomers extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO;
	private HttpSession httpSession;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			customerDAO  = new CustomerDAOImpl();					
			httpSession  = request.getSession(false);
			
			if(httpSession != null)
				httpSession.setAttribute("customers", customerDAO.getAllCustomers());

			request.getRequestDispatcher("/customers.jsp").forward(request, response);
		}
		
		catch (Exception exception) 
		{
			System.out.println("-------- INSIDE GETALLPRODUCTS.JAVA CATCH --------");
			exception.printStackTrace();
		}
	}

}
