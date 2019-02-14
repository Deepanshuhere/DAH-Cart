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
	private String categoryId;
	private ProductDAO productDAO;
	private HttpSession httpSession;
	private String categoryName;
	private List<Category> categories;
	private Iterator<Category> iterator;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			categoryId  = request.getParameter("categoryId");
			System.out.println("category id is =>"+categoryId);
			System.out.println("session hai? "+httpSession);
			productDAO  = new ProductDAOImpl();
			httpSession = request.getSession(false);
			
			if(httpSession == null)
			{
				System.out.println("inside else session == null");
				categoryName    = request.getParameter("category");
				categories  = (List<Category>)getServletContext().getAttribute("categories");
				iterator    = categories.iterator();

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
			
			else if(httpSession.getAttribute("requestFrom") != null ) 
			{
				System.out.println("inside != null");
				httpSession.setAttribute("products", productDAO.getProducts(categoryId));
				request.getRequestDispatcher("/displayproducts.jsp").forward(request, response);
			}
			
			
			System.out.println("GADBAD HAI");
			
		}
		
		catch(Exception e)
		{
			System.out.println("--------------- INSIDE GETPRODUCTS.JAVA CATCH BLOCK -------------------");
			e.printStackTrace();
		}
	}
}