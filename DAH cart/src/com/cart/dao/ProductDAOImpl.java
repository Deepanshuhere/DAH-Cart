package com.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cart.connection.ConnectionProvider;
import com.cart.model.Product;
import com.cart.model.Sales;

public class ProductDAOImpl implements ProductDAO 
{
	private Connection connection;
	private List<Product> products;
	private List<Sales> sales;
	private PreparedStatement preparedStatement;
	private Product product;
	private Sales sale;
	private ResultSet resultSet;
	private String query;
	private int status;
	
	@Override
	public int add(Product product)
	{
		try 
		{
			connection		  = ConnectionProvider.getConnection();
			query			  = "insert into product values(?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);	
			
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.setString(4, product.getDescription());
			preparedStatement.setInt(5, product.getQuantity());
			preparedStatement.setInt(6, product.getCategoryId());
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
	public int delete(int productId)
	{
		try
		{
			connection		  = ConnectionProvider.getConnection();
			query			  = "delete from product where id=?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, productId);

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
			query 			  = "UPDATE PRODUCT SET NAME = ?, PRICE = ?, DESCRIPTION = ?, QUANTITY = ? WHERE ID = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, product.getName());
			preparedStatement.setDouble(2, product.getPrice());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.setInt   (4, product.getQuantity());
			preparedStatement.setInt   (5, product.getId());

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
	public Product getProduct(int id) 
	{
		try
		{
			connection		  = ConnectionProvider.getConnection();
			query			  = "select * from product where id=?";
			preparedStatement = connection.prepareStatement(query);
		
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				product = new Product();
				product.setId(resultSet.getInt(1));
				product.setName(resultSet.getString(2));
				product.setPrice(resultSet.getInt(3));
				product.setDescription(resultSet.getString(4));
				product.setQuantity(resultSet.getInt(5));
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
		
			products		  = new ArrayList<>();
			query			  = "select * from product";
			preparedStatement = connection.prepareStatement(query);
			resultSet		  = preparedStatement.executeQuery();
		
			while(resultSet.next())
			{
				product=new Product();
				product.setId(resultSet.getInt(1));
				product.setName(resultSet.getString(2));
				product.setPrice(resultSet.getInt(3));
				product.setDescription(resultSet.getString(4));
				product.setQuantity(resultSet.getInt(5));
				products.add(product);
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
		
		return products;
	}

	@Override
	public List<Product> getProducts(int categoryId) 
	{
		try
		{
			connection=ConnectionProvider.getConnection();
		
			products		  = new ArrayList<>();
			query			  = "select * from product where category_id=?";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, categoryId);
			
			resultSet		  = preparedStatement.executeQuery();
		
			while(resultSet.next())
			{
				product=new Product();
				product.setId(resultSet.getInt(1));
				product.setName(resultSet.getString(2));
				product.setPrice(resultSet.getInt(3));
				product.setDescription(resultSet.getString(4));
				product.setQuantity(resultSet.getInt(5));
				products.add(product);
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
		
		return products;
	}

	@Override
	public int addSales(Sales sales) 
	{
		try 
		{
			connection		  = ConnectionProvider.getConnection();
			query			  = "INSERT INTO SALES VALUES(?, SYSDATE ,?)";
			preparedStatement = connection.prepareStatement(query);	
			
			preparedStatement.setString(1, sales.getCustomer().getEmail());
			preparedStatement.setInt   (2, sales.getAmount());
			status = preparedStatement.executeUpdate();
		} 
		
		catch (SQLException e) 
		{
			System.out.println("---------------- EXCEPTION FROM PRODUCTDAOIMPL ADDSALES() CATCH BLOCK --------------");
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
				System.out.println("---------------- EXCEPTION FROM PRODUCTDAOIMP ADDSALES() CONNECTION CLOSING --------------");
				e.printStackTrace();
			}
		}

		return status;
	}

	@Override
	public List<Sales> getSales() 
	{
		try
		{
			connection=ConnectionProvider.getConnection();
		
			sales			  = new ArrayList<>();
			query			  = "SELECT * FROM SALES";
			preparedStatement = connection.prepareStatement(query);
			resultSet		  = preparedStatement.executeQuery();
		
			while(resultSet.next())
			{
				sale = new Sales();
				sale.setCustomer(new CustomerDAOImpl().getCustomer( resultSet.getString(1)) );
				sale.setDate  (resultSet.getDate(2));
				sale.setAmount(resultSet.getInt(3));
				
				sales.add(sale);
			}
		}
		
		catch(SQLException e)
		{
			System.out.println("---------------- EXCEPTION FROM PRODUCTDAOIMPL GETSALES()CATCH BLOCK --------------");
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
				System.out.println("---------------- EXCEPTION FROM PRODUCTDAOIMPL GETSALES() CONNECTION CLOSING --------------");
				e.printStackTrace();
			}
		}
		
		return sales;
		}

} 