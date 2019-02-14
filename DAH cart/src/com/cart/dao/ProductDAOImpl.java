package com.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cart.connection.ConnectionProvider;
import com.cart.model.Product;

public class ProductDAOImpl implements ProductDAO 
{
	private Connection connection;
	private List<Product> list;
	private PreparedStatement preparedStatement;
	private Product product;
	private ResultSet resultSet;
	private String query;
	private int status;
	
	@Override
	public int add(Product product)
	{
		try 
		{
			connection		  = ConnectionProvider.getConnection();
			query			  = "insert into product values(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);	
				
			preparedStatement.setString(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.setString(4, product.getDescription());
			preparedStatement.setString(5, product.getCategoryId());
			status = preparedStatement.executeUpdate();
		} 
		
		catch (SQLException e) 
		{
			System.out.println("---------------- EXCEPTION FROM PRODUCTDAOIMPL ADD()--------------");
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
				System.out.println("---------------- EXCEPTION FROM PRODUCTDAOIMP ADD CONNECTION CLOSING --------------");
				e.printStackTrace();
			}
		}

		return status;
	}

	@Override
	public int delete(String productId)
	{
		try
		{
			connection		  = ConnectionProvider.getConnection();
			query			  = "delete from product where id=?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, productId);

			status =  preparedStatement.executeUpdate();
		}
		
		catch(SQLException e)
		{
			System.out.println("---------------- EXCEPTION FROM PRODUCATDAOIMPL DELETE--------------");
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
				System.out.println("---------------- EXCEPTION FROM PRODUCATDAOIMPL DELETE CONNECTION CLOSING --------------");
				e.printStackTrace();
			}
			
		}
			
		return status;
	}

	@Override
	public int update(Product product)
	{
		try
		{
			connection		  = ConnectionProvider.getConnection();
			query 			  = "UPDATE PRODUCT SET NAME = ?, PRICE = ?, DESCRIPTION = ? WHERE ID = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, product.getName());
			preparedStatement.setDouble(2, product.getPrice());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.setString(4, product.getId());
			status = preparedStatement.executeUpdate();
		}
		
		catch(SQLException e)
		{
			System.out.println("---------------- EXCEPTION FROM PRODUCTDAOIMPL UPDATE()--------------");
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
				System.out.println("---------------- EXCEPTION FROM PRODUCTDAOIMPL UPDATE() CONNECTION CLOSING --------------");
				e.printStackTrace();
			}
		}
		
		return status;
	}

	@Override
	public Product getProduct(String id) 
	{
		try
		{
			connection		  = ConnectionProvider.getConnection();
			query			  = "select * from product where id=?";
			preparedStatement = connection.prepareStatement(query);
		
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				product = new Product();
				product.setId(resultSet.getString(1));
				product.setName(resultSet.getString(2));
				product.setPrice(resultSet.getInt(3));
				product.setDescription(resultSet.getString(4));
			}
		
		//alter table product modify ( price number(6);
		}
		
		catch(SQLException e)
		{
			System.out.println("---------------- EXCEPTION FROM PRODUCTDAOIMPL GETPRODUCT() --------------");
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
				System.out.println("---------------- EXCEPTION FROM PRODUCTDAOIMPL GETPRODUCT() CONNECTION CLOSING --------------");
				e.printStackTrace();
			}
		}
		
		return product;
	}

	@Override
	public List<Product> getAllProducts()
	{
		try
		{
			connection=ConnectionProvider.getConnection();
		
			list			  = new ArrayList<>();
			query			  = "select * from product";
			preparedStatement = connection.prepareStatement(query);
			resultSet		  = preparedStatement.executeQuery();
		
			while(resultSet.next())
			{
				product=new Product();
				product.setId(resultSet.getString(1));
				product.setName(resultSet.getString(2));
				product.setPrice(resultSet.getInt(3));
				product.setDescription(resultSet.getString(4));
				list.add(product);
			}
		}
		
		catch(SQLException e)
		{
			System.out.println("---------------- EXCEPTION FROM PRODUCTDAOIMPL GETALLPRODUCTS()() --------------");
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
				System.out.println("---------------- EXCEPTION FROM PRODUCTDAOIMPL GETALLPRODUCTS() CONNECTION CLOSING --------------");
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public List<Product> getProducts(String categoryId) 
	{
		try
		{
			connection=ConnectionProvider.getConnection();
		
			list			  = new ArrayList<>();
			query			  = "select * from product where categoryid=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, categoryId);
			resultSet		  = preparedStatement.executeQuery();
		
			while(resultSet.next())
			{
				product=new Product();
				product.setId(resultSet.getString(1));
				product.setName(resultSet.getString(2));
				product.setPrice(resultSet.getInt(3));
				product.setDescription(resultSet.getString(4));
				list.add(product);
			}
		}
		
		catch(SQLException e)
		{
			System.out.println("---------------- EXCEPTION FROM PRODUCTDAOIMPL GETALLPRODUCTS()() --------------");
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
				System.out.println("---------------- EXCEPTION FROM PRODUCTDAOIMPL GETALLPRODUCTS() CONNECTION CLOSING --------------");
				e.printStackTrace();
			}
		}
		
		return list;
	}

}