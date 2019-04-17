package com.cart.connection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Enumeration;
import java.util.Properties;

public class ConnectionProvider 
{
	private static Properties properties;
	private static FileInputStream fileInputStream;
	private static Enumeration<String> enumeration;
	private static Connection connection;
	private static String url;
	private static String username;
	private static String password;

	public static Connection getConnection()
	{
		try 
		{
			properties = new Properties();
			fileInputStream = new FileInputStream("D:\\workspace\\spring_eclipse\\DAH cart\\src\\com\\cart\\connection\\database.properties");
			properties.load(fileInputStream);
			enumeration = (Enumeration<String>) properties.propertyNames();
			
			while(enumeration.hasMoreElements())
			{
				String key   = enumeration.nextElement();
				String value = properties.getProperty(key);
				
				if(key.equals("url"))
					url = value;

				else if(key.equals("username"))
					username = value;
				
				else if(key.equals("password"))
					password = value;
			}
			
			connection = DriverManager.getConnection(url, username, password);
		}
		
		catch (Exception e) 
		{
			System.out.println("-------------- EXCEPTION FROM CONNECTIONPROVIDER.JAVA ---------------");
			e.printStackTrace();
		}
		
		finally 
		{
			return connection;
		}
		
	}
}
