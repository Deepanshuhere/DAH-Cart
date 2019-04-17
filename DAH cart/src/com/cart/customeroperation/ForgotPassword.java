package com.cart.customeroperation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cart.dao.CustomerDAO;
import com.cart.dao.CustomerDAOImpl;

@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private String email;
	private String answer;
	private CustomerDAO customerDAO;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			email   	= request.getParameter("email");
			System.out.println(email);
			//ghjgjh
			answer		= request.getParameter("answer");
			customerDAO = new CustomerDAOImpl(); 
		
			if(customerDAO.checkUser(email, answer))
			{
				request.setAttribute("email",email);
				System.out.println("SECURITY ANSWER IS CORRECT");
				request.getRequestDispatcher("/updatepassword.jsp").forward(request, response);
			}
			
			else
				request.getRequestDispatcher("/forgotpassword.jsp").forward(request, response);
			
			
		}
		
		catch (Exception exception) 
		{
			System.out.println("-------------- EXCEPTION FROM FORGOTPASSWORD.JAVA CATCH BLOCK ---------------");
			exception.printStackTrace();
		}
	}

}
