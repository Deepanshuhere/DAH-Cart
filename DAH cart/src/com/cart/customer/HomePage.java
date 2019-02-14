package com.cart.customer;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cart.dao.CategoryDAO;
import com.cart.dao.CategoryDAOImpl;
import com.cart.dao.ProductDAO;
import com.cart.dao.ProductDAOImpl;
import com.cart.model.Category;

@WebServlet("/HomePage")
public class HomePage extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
	private CategoryDAO categoryDAO;
	private List<Category> categories;
	private Iterator<Category> iterator;
	private Category category;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			productDAO  = new ProductDAOImpl();
			categoryDAO = new CategoryDAOImpl();
			categories  = categoryDAO.getAll();
			iterator    = categories.iterator();
			
			while(iterator.hasNext())
			{
				category = iterator.next();
				request.setAttribute(category.getName(),productDAO.getProducts(category.getId()));
			}
			request.setAttribute("categories", categories);
		}
		
		catch (Exception exception) 
		{
			System.out.println("-------- INSIDE HOMEPRODUCT.JAVA CATCH --------");
			exception.printStackTrace();
		}
	}
}