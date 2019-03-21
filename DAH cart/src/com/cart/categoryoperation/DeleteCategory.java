package com.cart.categoryoperation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cart.dao.CategoryDAO;
import com.cart.dao.CategoryDAOImpl;

@WebServlet("/DeleteCategory")
public class DeleteCategory extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private int categoryId;
	private CategoryDAO categoryDAO;
	private int status;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			categoryId  = Integer.parseInt(request.getParameter("id"));
			categoryDAO = new CategoryDAOImpl();
			status 	    = categoryDAO.delete(categoryId);
			
			if(status == 1)
				request.getRequestDispatcher("/GetAllCategory").forward(request, response);
			
			else
			{
				System.out.println("CATEGORY NOT DELETED!!!!!!!");
				request.getRequestDispatcher("/GetAllCategory").forward(request, response);
			}
		}
		
		catch(Exception e)
		{
			System.out.println("---------------Inside DeleteCategory.java catch block------------------");
			e.printStackTrace();
		}
	}

}
