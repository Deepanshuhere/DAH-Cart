package com.cart.model;

import java.io.Serializable;
import java.util.UUID;

public class Category implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	
	public String getId() 
	{
		return id;
	}
	
	public void setId(String id) 
	{
		if(id == null)		
			this.id= UUID.randomUUID().toString().substring(0, 5);
			
		else	
			this.id = id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
}