package com.cart.customeroperation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cart.dao.CustomerDAO;
import com.cart.dao.CustomerDAOImpl;


@WebServlet("/GetCustomer")
public class GetCustomer extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO;
	private String email;
	  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			email 		 = (String) request.getSession(false).getAttribute("email"); 
			customerDAO  = new CustomerDAOImpl();					
			
			request.setAttribute("customer", customerDAO.getCustomer(email));
			request.getRequestDispatcher("/updatecustomer.jsp").forward(request, response);
		}
		
		catch (Exception exception) 
		{
			System.out.println("-------- INSIDE GETALLPRODUCTS.JAVA CATCH --------");
			exception.printStackTrace();
		}
	}

}
