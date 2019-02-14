package com.cart.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.dao.CategoryDAO;
import com.cart.dao.CategoryDAOImpl;
import com.cart.dao.CustomerDAO;
import com.cart.dao.CustomerDAOImpl;
import com.cart.dao.ProductDAO;
import com.cart.dao.ProductDAOImpl;
import com.cart.model.Customer;
import com.cart.model.Product;

@WebServlet("/Login")									
public class Login extends HttpServlet 
{
	private static final long serialVersionUID = 1L;  
	private String id;
	private String password;
	private CustomerDAO customerDAO;
	private Customer customer;
	private RequestDispatcher requestDispatcher;
	private HttpSession httpSession;
	private String userName;
	private ProductDAO productDAO;
	private CategoryDAO categoryDAO;
	private int cartQuantity;
	private List<Product> cartProducts;
	
	private boolean isNumber(String id)
	{
		for(char ch:id.toCharArray())
			if(!Character.isDigit(ch))
				return false;
	
		return true;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			id			= request.getParameter("id");
			password	= request.getParameter("password");
			customerDAO = new CustomerDAOImpl(); 
			
			if(isNumber(id))
				customer = customerDAO.findByNumber(Long.parseLong(id), password);
			
			else
				customer = customerDAO.findByEmail(id, password);
						
			if(customer == null)
			{
				requestDispatcher=request.getRequestDispatcher("/login.jsp");
				requestDispatcher.forward(request, response);
			}
		
			else
			{
				userName = customer.getName(); 
				categoryDAO = new CategoryDAOImpl();
				
				if(customer.getRole().equals("ROLE_ADMIN"))
				{
					httpSession  = request.getSession();
					productDAO   = new ProductDAOImpl();
					cartProducts = new ArrayList<>();
					
					httpSession.setAttribute("role",userName);
					httpSession.setAttribute("indexRef", "admin.jsp");
					httpSession.setAttribute("login", "");
					httpSession.setAttribute("categories", categoryDAO.getAll());
					httpSession.setAttribute("customers", customerDAO.getAllCustomers());
					httpSession.setAttribute("products", productDAO.getAllProducts());
					httpSession.setAttribute("email", customer.getEmail());
					httpSession.setAttribute("categories", categoryDAO.getAll());
					httpSession.setAttribute("cartProducts", cartProducts);
					
					//httpSession.setMaxInactiveInterval(10);
					requestDispatcher=request.getRequestDispatcher("/admin.jsp");
					requestDispatcher.forward(request, response);
				}
			
				else if(customer.getRole().equals("ROLE_USER"))
				{
					httpSession = request.getSession();
					httpSession.setAttribute("login", "");
					httpSession.setAttribute("role",userName);
					httpSession.setAttribute("indexRef", "index.jsp");
					httpSession.setAttribute("email", customer.getEmail());
					httpSession.setAttribute("categories", categoryDAO.getAll());
					httpSession.setAttribute("cartQuantity", cartQuantity);
					//httpSession.setMaxInactiveInterval(10);
					requestDispatcher=request.getRequestDispatcher("/index.jsp");
					requestDispatcher.forward(request, response);
				}
			}//else
		
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
}