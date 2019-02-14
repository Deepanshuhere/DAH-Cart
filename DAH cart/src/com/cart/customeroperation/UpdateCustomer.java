package com.cart.customeroperation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cart.dao.CustomerDAO;
import com.cart.dao.CustomerDAOImpl;
import com.cart.model.Customer;

@WebServlet("/UpdateCustomer")
public class UpdateCustomer extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private String name;
	private long number;
	private String email;
	private String oldEmail;
	private String password;
	private Customer customer;
	private CustomerDAO customerDAO;
	private int status;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			name	 	= request.getParameter("name");
			number	 	= Long.parseLong(request.getParameter("number"));
			email 	 	= request.getParameter("email");
			password 	= request.getParameter("password");
			customer 	= new Customer();
			customerDAO = new CustomerDAOImpl();
			oldEmail 	= (String)request.getSession(false).getAttribute("email");
			
			customer.setName(name);
			customer.setPhone(number);
			customer.setEmail(email);
			customer.setPassword(password);
			
			status = customerDAO.update(customer, oldEmail);
			
			if(status == 1);
			{
				System.out.println("------------ CUSTOMER UPDATED ------------");
				
				if(name.equalsIgnoreCase("admin"))
					request.getRequestDispatcher("admin.jsp").forward(request, response);
			
				else
					request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
		}
		
		catch (Exception e) 
		{
			System.out.println("------------- EXCEPTION FROM UPDATECUSTOMER CATCH BLOCK ----------");
		}
		
		
		
	}

}