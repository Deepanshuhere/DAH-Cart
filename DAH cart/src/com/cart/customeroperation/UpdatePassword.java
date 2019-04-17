package com.cart.customeroperation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cart.dao.CustomerDAO;
import com.cart.dao.CustomerDAOImpl;

@WebServlet("/UpdatePassword")
public class UpdatePassword extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private String password;
	private String email;
	private CustomerDAO customerDAO;
	private int status;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			email		 = request.getParameter("email");
			password  	 = request.getParameter("password");
			customerDAO  = new CustomerDAOImpl();
			status 		 = customerDAO.updatePassword(email, password);
			
			System.out.println();
			System.out.println("email is "+email);
			System.out.println("password is "+password);
			
			if(status == 1)
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			
			else
				request.getRequestDispatcher("/updatepassword.jsp").forward(request, response);
			
			
		}
		
		catch (Exception exception) 
		{
			System.out.println("------------------------ EXCEPTION FROM UPDATEPASSWORD.JAVA CATCH BLOCK ------------");
			exception.printStackTrace();
		}
	}

}
