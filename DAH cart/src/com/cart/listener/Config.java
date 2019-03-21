package com.cart.listener;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private String query;
	private String customerTableQuery;
	private String productTableQuery;
	private String categoryTableQuery;
	
    public void contextInitialized(ServletContextEvent event) 
    {
    	try 
		{
    		/*connection	= ConnectionProvider.getConnection();
			query		= "SELECT * FROM CUSTOMER WHERE NAME='ADMIN'";
			statement	= connection.createStatement();
			resultSet	= statement.executeQuery(query);
			
			if(resultSet.next() == false)
			{
				//
				customerTableQuery = "CREATE TABLE CUSTOMER(\r\n" + 
						"NAME        VARCHAR2(50) NOT NULL,\r\n" + 
						"GENDER      VARCHAR2(6)  NOT NULL,\r\n" + 
						"PHONE       NUMBER(10)   NOT NULL UNIQUE,\r\n" + 
						"EMAIL       VARCHAR2(50) PRIMARY KEY,\r\n" + 
						"PASSWORD    VARCHAR2(30) NOT NULL,\r\n" + 
						"ROLE        VARCHAR2(10) NOT NULL,\r\n" + 
						"ANSWER      VARCHAR2(30) NOT NULL\r\n" + 
						")"; 
				
			
				categoryTableQuery = "CREATE TABLE CATEGORY(\r\n" + 
						"CATEGORY_ID      NUMBER(10) PRIMARY KEY,\r\n" + 
						"CATEGORY_NAME    VARCHAR2(20) NOT NULL\r\n" + 
						")";
				
				productTableQuery  = "CREATE TABLE PRODUCT(\r\n" + 
						"ID              NUMBER(10)      PRIMARY KEY,\r\n" + 
						"NAME            VARCHAR2(100)  NOT NULL,\r\n" + 
						"PRICE           NUMBER(10)      NOT NULL,\r\n" + 
						"DESCRIPTION     VARCHAR2(1000)  NOT NULL,\r\n" + 
						"QUANTITY        NUMBER(5)       NOT NULL,\r\n" + 
						"CATEGORY_ID     NUMBER(10)      REFERENCES CATEGORY(CATEGORY_ID)\r\n" + 
						")";

				statement.executeQuery(customerTableQuery);
				statement.executeQuery(categoryTableQuery);
				statement.executeQuery(productTableQuery);
				
				System.out.println("/n -------------------INSIDE IF TABLE NOT EXIST CONFIG.JAVA ----------------- /n");
			}*/
    		
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
    
    public void contextDestroyed(ServletContextEvent event) 
    {
    	
    }

}
