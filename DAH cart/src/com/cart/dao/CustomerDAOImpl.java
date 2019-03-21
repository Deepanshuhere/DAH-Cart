package com.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cart.connection.ConnectionProvider;
import com.cart.model.Customer;

public class CustomerDAOImpl implements CustomerDAO 
{
	private Connection connection;
	private PreparedStatement preparedStatement;
	private String query;
	private ResultSet resultSet;
	private Customer customer;
	private int status;
	private List<Customer> customerList;
	
	@Override
	public int add(Customer customer) 
	{
		try
		{
			connection		  = ConnectionProvider.getConnection();
			query			  = "INSERT INTO CUSTOMER VALUES(?,?,?,?,?,?,?,?)";	
			preparedStatement = connection.prepareStatement(query);	
		
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getGender());
			preparedStatement.setLong  (3, customer.getPhone());
			preparedStatement.setString(4, customer.getEmail());
			preparedStatement.setString(5, customer.getPassword());
			preparedStatement.setString(6, customer.getRole());
			preparedStatement.setString(7, customer.getAnswer());
			preparedStatement.setString(8, null);
				
			status = preparedStatement.executeUpdate();
		}
		
		catch(SQLException e)
		{
			System.out.println("----------- EXCEPTION FROM CUSTOMERDAOIMPL  ADD() --------------");
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
				System.out.println("---------------- EXCEPTION FROM CUSTOMERDAOIMPL ADD() CONNECTION CLOSING --------------");
				e.printStackTrace();
			}
		}
		
		return status;
	}

	@Override
	public Customer findByEmail(String email, String password) 
	{
		try
		{
			connection		  = ConnectionProvider.getConnection();
			query			  = "select * from customer where email=? and password=?";
			preparedStatement = connection.prepareStatement(query);	
			customer          = new Customer();
			
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
		
			resultSet = preparedStatement.executeQuery();
				
			while(resultSet.next())
			{
				customer.setName     (resultSet.getString(1));
				customer.setGender   (resultSet.getString(2));
				customer.setPhone    (resultSet.getLong(3));
				customer.setEmail	 (resultSet.getString(4));
				customer.setPassword (resultSet.getString(5));
				customer.setRole	 (resultSet.getString(6));
				customer.setAnswer	 (resultSet.getString(7));
			}
					
		}

		catch(SQLException e)
		{
			System.out.println("----------- EXCEPTION FROM CUSTOMERDAOIMPL FINDBYEMAIL() --------------");
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
				System.out.println("---------------- EXCEPTION FROM CUSTOMERDAOIMPL FINDBYEMAIL() CONNECTION CLOSING --------------");
				e.printStackTrace();
			}
		}
		
		if(customer.getName() == null)
			return null;
		
		else
			return customer;
	}
	
	@Override
	public int delete(Customer customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Customer customer,String oldEmail) 
	{
		try
		{
			connection 	      = ConnectionProvider.getConnection();
			query	   		  = "UPDATE CUSTOMER SET NAME = ?, PHONE = ?, EMAIL = ?, PASSWORD = ?, ANSWER = ?, ADDRESS = ? WHERE EMAIL = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setLong  (2, customer.getPhone());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setString(4, customer.getPassword());
			preparedStatement.setString(5, customer.getAnswer());
			preparedStatement.setString(6, customer.getAddress());
			preparedStatement.setString(7, oldEmail);
			
			
			status = preparedStatement.executeUpdate();		
		}
		
		catch(SQLException e)
		{
			System.out.println("---------------- EXCEPTION FROM CUSTOMERDAOIMPL UPDATE()--------------");
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
				System.out.println("---------------- EXCEPTION FROM CUSTOMERDAOIMPL UPDATE() CONNECTION CLOSING --------------");
				e.printStackTrace();
			}
		}
	
		return status;
	}

	@Override
	public List<Customer> getAllCustomers() 
	{
		try
		{
			connection 		  = ConnectionProvider.getConnection(); 
			query	   		  = "SELECT * FROM CUSTOMER";
			preparedStatement = connection.prepareStatement(query);
			resultSet		  = preparedStatement.executeQuery();
			customerList	  = new ArrayList<Customer>();
			
			while(resultSet.next())
			{	
				Customer customer = new Customer();
				
				customer.setName	(resultSet.getString(1));
				customer.setGender	(resultSet.getString(2));
				customer.setPhone	(resultSet.getLong(3));  
				customer.setEmail	(resultSet.getString(4));
				customer.setPassword(resultSet.getString(5));
				customer.setRole	(resultSet.getString(6));
				customer.setAnswer	(resultSet.getString(7));
				
				if(!resultSet.getString(1).equals("Admin"))	
					customerList.add(customer);
			}			
		}
		
		catch(SQLException e)
		{
			System.out.println("---------------- EXCEPTION FROM CUSTOMERDAOIMPL GETALLCUSTOMERS() -----------------");
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
				System.out.println("---------------- EXCEPTION FROM CUSTOMERDAOIMPL GETALLCUSTOMERS() CLOSING CONNECTION -----------------");
				e.printStackTrace();
			}
		}
		
		return customerList;
	}//getAllCustomers()

	@Override
	public Customer findByNumber(long number, String password) 
	{
		try
		{
			connection		  = ConnectionProvider.getConnection();
			query			  = "select * from customer where phone=? and password=?";
			preparedStatement = connection.prepareStatement(query);	
			customer          = new Customer();
			
			preparedStatement.setLong(1, number);
			preparedStatement.setString(2, password);
		
			resultSet = preparedStatement.executeQuery();
				
			while(resultSet.next())
			{
				customer.setName     (resultSet.getString(1));
				customer.setGender   (resultSet.getString(2));
				customer.setPhone    (resultSet.getLong(3));
				customer.setEmail	 (resultSet.getString(4));
				customer.setPassword (resultSet.getString(5));
				customer.setRole	 (resultSet.getString(6));
				customer.setAnswer	 (resultSet.getString(7));
			}
		}

		catch(SQLException e)
		{
			System.out.println("----------- EXCEPTION FROM CUSTOMERDAOIMPL FINDBYNUMBER() --------------");
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
				System.out.println("---------------- EXCEPTION FROM CUSTOMERDAOIMPL FINDBYNUMBER() CONNECTION CLOSING --------------");
				e.printStackTrace();
			}
		}
		
		if(customer.getName() == null)
			return null;
		
		else
			return customer;
	}

	@Override
	public Customer getCustomer(String email) 
	{
		try
		{
			connection 		  = ConnectionProvider.getConnection(); 
			query	   		  = "SELECT * FROM CUSTOMER WHERE EMAIL=?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, email);
			
			resultSet  = preparedStatement.executeQuery();
			customer   = new Customer();
			
			
			while(resultSet.next())
			{
				customer.setName	(resultSet.getString(1));
				customer.setGender	(resultSet.getString(2));
				customer.setPhone	(resultSet.getLong(3));  
				customer.setEmail	(resultSet.getString(4));
				customer.setPassword(resultSet.getString(5));
				customer.setRole	(resultSet.getString(6));
				customer.setAnswer	(resultSet.getString(7));
			}			
		}
		
		catch(SQLException e)
		{
			System.out.println("---------------- EXCEPTION FROM CUSTOMERDAOIMPL GETCUSTOMER() -----------------");
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
				System.out.println("---------------- EXCEPTION FROM CUSTOMERDAOIMPL GETCUSTOMER() CLOSING CONNECTION -----------------");
				e.printStackTrace();
			}
		}
		
		return customer;
	}

	@Override
	public boolean checkUser(String email, String answer) 
	{
		try
		{
			connection 		  = ConnectionProvider.getConnection(); 
			query	   		  = "SELECT * FROM CUSTOMER WHERE EMAIL=? AND ANSWER=?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, answer);
			
			resultSet  = preparedStatement.executeQuery();
			
			if(resultSet.next())
				return true;
		
		}
		
		catch(SQLException e)
		{
			System.out.println("---------------- EXCEPTION FROM CUSTOMERDAOIMPL CHECKUSER() -----------------");
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
				System.out.println("---------------- EXCEPTION FROM CUSTOMERDAOIMPL CHECKUSER() CLOSING CONNECTION -----------------");
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public int updatePassword(String email, String newPassword) 
	{
		try
		{
			connection 		  = ConnectionProvider.getConnection(); 
			query	   		  = "UPDATE CUSTOMER SET PASSWORD = ? WHERE EMAIL = ?";
			preparedStatement = connection.prepareStatement(query);

			System.out.println("email in dao is ->"+email);
			System.out.println("password in dao is ->"+newPassword);
			
			preparedStatement.setString(1, newPassword);
			preparedStatement.setString(2, email);

			status = preparedStatement.executeUpdate();
			System.out.println("###################"+status+"#################");
		}
		
		catch(SQLException e)
		{
			System.out.println("---------------- EXCEPTION FROM CUSTOMERDAOIMPL UPDATEPASSWORD() -----------------");
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
				System.out.println("---------------- EXCEPTION FROM CUSTOMERDAOIMPL UPDATEPASSWORD() CLOSING CONNECTION -----------------");
				e.printStackTrace();
			}
		}
		return status;
	}
}