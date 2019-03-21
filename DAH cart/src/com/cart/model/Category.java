package com.cart.model;

import java.io.Serializable;
import java.util.UUID;

public class Category implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		if(id == 0)		
			this.id = UUID.randomUUID().toString().substring(1, 4).hashCode();
		
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