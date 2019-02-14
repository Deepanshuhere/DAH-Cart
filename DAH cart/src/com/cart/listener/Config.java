package com.cart.listener;

import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.cart.dao.CategoryDAO;
import com.cart.dao.CategoryDAOImpl;
import com.cart.dao.ProductDAO;
import com.cart.dao.ProductDAOImpl;
import com.cart.model.Category;

@WebListener
public class Config implements ServletContextListener 
{
	private ServletContext servletContext;
	private ProductDAO productDAO;
	private CategoryDAO categoryDAO;
	private List<Category> categories;
	private Iterator<Category> iterator;
	private Category category;
	
    public void contextInitialized(ServletContextEvent event) 
    {
    	try 
		{
    		servletContext = event.getServletContext();
        	productDAO     = new ProductDAOImpl();
			categoryDAO    = new CategoryDAOImpl();
			categories     = categoryDAO.getAll();
			iterator       = categories.iterator();
			
			while(iterator.hasNext())
			{
				category = iterator.next();
				servletContext.setAttribute(category.getName(),productDAO.getProducts(category.getId()));
			}
			
			servletContext.setAttribute("categories", categories);
		}
		
		catch (Exception exception) 
		{
			System.out.println("-------- INSIDE CONFIG.JAVA CATCH --------");
			exception.printStackTrace();
		}
    }
    
    public void contextDestroyed(ServletContextEvent event) {
        // Do stuff during webapp's shutdown.
    }
}