package com.cart.categoryoperation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cart.dao.CategoryDAO;
import com.cart.dao.CategoryDAOImpl;
import com.cart.model.Category;

@WebServlet("/AddCategory")
public class AddCategory extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private String categoryName;
     private Category category;
	private CategoryDAO categoryDAO;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		categoryName		= request.getParameter("categoryName");
		category			= new Category();
		
		category.setId(0);
		category.setName(categoryName);
		
		categoryDAO			= new CategoryDAOImpl();
		
		try 
		{
			if(categoryDAO.add(category) == 1)
				request.getRequestDispatcher("/GetAllCategory").forward(request, response);
			
			else
				request.getRequestDispatcher("/GetAllCategory").forward(request, response);
		}
		
		catch (Exception exception) 
		{
			System.out.println("---------------- EXCEPTION FROM ADDCATEGORY.JAVA CATCH BLOCK ----------------");
			exception.printStackTrace();
		}
	}
}