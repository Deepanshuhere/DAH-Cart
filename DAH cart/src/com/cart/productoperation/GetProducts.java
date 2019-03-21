package com.cart.productoperation;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.dao.ProductDAO;
import com.cart.dao.ProductDAOImpl;
import com.cart.model.Category;


@WebServlet("/GetProducts")
public class GetProducts extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private int categoryId;
	private ProductDAO productDAO;
	private HttpSession httpSession;
	private String categoryName,requestFrom;
	private List<Category> categories;
	private Iterator<Category> iterator;
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			httpSession = request.getSession(false);
			requestFrom = (String) httpSession.getAttribute("requestFrom");
			productDAO  = new ProductDAOImpl();
			
			
			System.out.println("request is coming from "+requestFrom);
			
			if(requestFrom.equalsIgnoreCase("index.jsp"))
			{
				categoryName = request.getParameter("categoryName"); 
			
				categories   = (List<Category>)getServletContext().getAttribute("categories");
				iterator     = categories.iterator();

				while(iterator.hasNext())
				{
					Category category = iterator.next();
					if(category.getName().equalsIgnoreCase(categoryName))
					{
						categoryId = category.getId();
						request.setAttribute("products", productDAO.getProducts(categoryId));
						System.out.println(request.getAttribute("products"));
						request.getRequestDispatcher("/products.jsp").forward(request, response);
					}
				}
			
			}
			
			else// if(requestFrom.equalsIgnoreCase("displayproducts.jsp"))
			{
				categoryId   = Integer.parseInt(request.getParameter("categoryId"));
			
				httpSession.setAttribute("products", productDAO.getProducts(categoryId));
				request.getRequestDispatcher("/displayproducts.jsp").forward(request, response);
			}
			
			
		/*  categoryId   = Integer.parseInt(request.getParameter("categoryId"));
			productDAO   = new ProductDAOImpl();
			//httpSession  = request.getSession(false);
			
			if(categoryId != 0)
			{
				httpSession  = request.getSession(false);
				httpSession.setAttribute("products", productDAO.getProducts(categoryId));
				request.getRequestDispatcher("/displayproducts.jsp").forward(request, response);
			}
			
			else if(!categoryName.equals(null))
			{
				System.out.println("inside categoryname not equals to null");
				
				categoryName = request.getParameter("category");
				categories   = (List<Category>)getServletContext().getAttribute("categories");
				iterator     = categories.iterator();

				while(iterator.hasNext())
				{
					Category category = iterator.next();
					if(category.getName().equalsIgnoreCase(categoryName))
					{
						categoryId = category.getId();
						request.setAttribute("products", productDAO.getProducts(categoryId));
						System.out.println(request.getAttribute("products"));
						request.getRequestDispatcher("/products.jsp").forward(request, response);
					}
				}
			}
			
			/*if(httpSession == null)
			{
				System.out.println("inside if session == null");
				
				categoryName = request.getParameter("category");
				categories   = (List<Category>)getServletContext().getAttribute("categories");
				iterator     = categories.iterator();

				while(iterator.hasNext())
				{
					Category category = iterator.next();
					if(category.getName().equalsIgnoreCase(categoryName))
					{
						categoryId = category.getId();
						request.setAttribute("products", productDAO.getProducts(categoryId));
						System.out.println(request.getAttribute("products"));
						request.getRequestDispatcher("/products.jsp").forward(request, response);
					}
				}
			}
			
			else
			{
				System.out.println("----------- SESSION NOT NULL FROM GETPRODUCTS.JAVA-------------");
			}
			
			/*else if(httpSession.getAttribute("requestFrom") != null ) 
			{
				System.out.println("inside != null");
				httpSession.setAttribute("products", productDAO.getProducts(categoryId));
				request.getRequestDispatcher("/displayproducts.jsp").forward(request, response);
			}*/
			
		}
		
		catch(Exception e)
		{
			System.out.println("--------------- INSIDE GETPRODUCTS.JAVA CATCH BLOCK -------------------");
			e.printStackTrace();
		}
	}
}