package com.cart.customer;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cart.dao.CustomerDAO;
import com.cart.dao.CustomerDAOImpl;
import com.cart.model.Customer;

@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name;
	private String gender;
	private long phone;
	private String email;
	private String password;
	private Customer customer;
	private CustomerDAO customerDAO;
	private RequestDispatcher requestDispatcher;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		name	 = request.getParameter("name");
		gender	 = request.getParameter("gender");
		phone	 = Long.parseLong(request.getParameter("number"));
		email	 = request.getParameter("email");
		password = request.getParameter("password");
		
		customer	= new Customer();
		customerDAO	= new CustomerDAOImpl();
		
		customer.setName(name);
		customer.setGender(gender);
		customer.setPhone(phone);
		customer.setEmail(email);
		customer.setPassword(password);
		customer.setRole(null);
		
		try 
		{
			if(customerDAO.add(customer) == 1)
			{
				requestDispatcher=request.getRequestDispatcher("/login.jsp");
				requestDispatcher.forward(request, response);
			}
			
			else
			{
				requestDispatcher=request.getRequestDispatcher("/signup.jsp");
				requestDispatcher.forward(request, response);
			}
			
		}
		
		catch (Exception exception) 
		{
			System.out.println("------ EXCEPTION FROM SIGNUP.JAVA ------");
			exception.printStackTrace();
		}
	}
}