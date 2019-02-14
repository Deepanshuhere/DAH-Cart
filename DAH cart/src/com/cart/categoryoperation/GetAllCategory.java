package com.cart.categoryoperation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.dao.CategoryDAO;
import com.cart.dao.CategoryDAOImpl;

@WebServlet("/GetAllCategory")
public class GetAllCategory extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private CategoryDAO categoryDAO;
	private HttpSession httpSession;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			categoryDAO = new CategoryDAOImpl();
			httpSession = request.getSession(false);
			
			if(httpSession != null)
				httpSession.setAttribute("categories", categoryDAO.getAll());
				
			request.getRequestDispatcher("/category.jsp").forward(request, response);
		}
		
		catch(Exception exception)
		{
			System.out.println("----------- INSIDE GETALLCATEGORY.JAVA CATCH BLOCK -------------");
			exception.printStackTrace();
		}
		
	}

}
