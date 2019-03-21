package com.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cart.connection.ConnectionProvider;
import com.cart.model.Category;

public class CategoryDAOImpl implements CategoryDAO 
{
	private Connection connection;
	private List<Category> categoryList;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String query;
	private Category category;
	private int status;
	private int categoryId;
	
	@Override
	public int add(Category category) 
	{
		try
		{
			connection		  = ConnectionProvider.getConnection();
			query			  = "insert into category values(?,?)";
			preparedStatement = connection.prepareStatement(query);
	
			preparedStatement.setInt(1, category.getId());
			preparedStatement.setString(2, category.getName());
			status = preparedStatement.executeUpdate();
		}
		
		catch(SQLException e)
		{
			System.out.println("----------- EXCEPTION FROM CATEGORYDAOIMPL  ADD() --------------");
			e.printStackTrace();
		}

		finally
		{
			try
			{
				connection.close();
			}
			
			catch(SQLException e)
			{
				System.out.println("---------------- EXCEPTION FROM CATEGORYDAOIMPL ADD() CONNECTION CLOSING --------------");
				e.printStackTrace();
			}
		}
		
		return status;
	}

	@Override
	public List<Category> getAll()
	{	
		try
		{
			connection		  = ConnectionProvider.getConnection();
			categoryList  	  = new ArrayList<Category>();
			query			  = "select * from category";
			preparedStatement = connection.prepareStatement(query);
			resultSet		  = preparedStatement.executeQuery();
		
			while(resultSet.next())
			{
				category = new Category();
				category.setId  (resultSet.getInt(1));
				category.setName(resultSet.getString(2));
				categoryList.add(category);
			}
		}
		
		catch(SQLException e)
		{
			System.out.println("----------- EXCEPTION FROM CATEGORYDAOIMPL  GETALL() --------------");
			e.printStackTrace();
		}

		finally
		{
			try
			{
				connection.close();
			}
			
			catch(SQLException e)
			{
				System.out.println("---------------- EXCEPTION FROM CATEGORYDAOIMPL GETALL() CONNECTION CLOSING --------------");
				e.printStackTrace();
			}
		}
		
			
		return categoryList;
	}

	@Override
	public int delete(int categoryId)
	{
		try
		{
			connection		  = ConnectionProvider.getConnection();
			query			  ="SELECT * FROM PRODUCT WHERE CATEGORY_ID=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, categoryId);
			resultSet 		  = preparedStatement.executeQuery();
			
			if(resultSet.next())
				return status;

			query			  = "DELETE FROM CATEGORY WHERE CATEGORY_ID=?";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, categoryId);

			status = preparedStatement.executeUpdate();
		}
		
		catch(SQLException e)
		{
			System.out.println("----------- EXCEPTION FROM CATEGORYDAOIMPL  DELETE() --------------");
			e.printStackTrace();
		}

		finally
		{
			try
			{
				connection.close();
			}
			
			catch(SQLException e)
			{
				System.out.println("------- --------- EXCEPTION FROM CATEGORYDAOIMPL DELETE() CONNECTION CLOSING --------------");
				e.printStackTrace();
			}
		}
		
		return status;
	}

	/*@Override
	public int getCategoryId(String categoryName) 
	{
		try
		{
			connection		  = ConnectionProvider.getConnection();
			query			  = "SELECT CATEGORY_ID FROM CATEGORY WHERE CATEGORY_NAME=?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, categoryName);
			
			resultSet 		  = preparedStatement.executeQuery();
			
			if(resultSet.next())
				categoryId = resultSet.getInt(1);
		}
		
		catch(SQLException e)
		{
			System.out.println("----------- EXCEPTION FROM CATEGORYDAOIMPL  DELETE() --------------");
			e.printStackTrace();
		}

		finally
		{
			try
			{
				connection.close();
			}
			
			catch(SQLException e)
			{
				System.out.println("------- --------- EXCEPTION FROM CATEGORYDAOIMPL DELETE() CONNECTION CLOSING --------------");
				e.printStackTrace();
			}
		}
		return categoryId;
	}*/
}