package com.cart.productoperation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.dao.ProductDAO;
import com.cart.dao.ProductDAOImpl;

@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private int productId;
	private ProductDAO productDAO;
	private int status;
	private HttpSession httpSession;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			productId  = Integer.parseInt(request.getParameter("id"));
			productDAO = new ProductDAOImpl();
			status 	   = productDAO.delete(productId);
			
			if(status == 1)
			{
				httpSession = request.getSession();
				if(httpSession != null)
					httpSession.setAttribute("products", productDAO.getAllProducts());
				
				request.getRequestDispatcher("/GetAllProducts").forward(request, response);
			}
			
			else
			{
				System.out.println("PRODUCT NOT DELETED!!!!!!!");
			}
		}
		
		catch(Exception e)
		{
			System.out.println("---------------Inside DeleteProduct.java catch block------------------");
		}
		
	}

}
