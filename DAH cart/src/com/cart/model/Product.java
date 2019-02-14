package com.cart.model;

import java.io.Serializable;
import java.util.UUID;

public class Product implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String description;
	private String categoryId;
	private int price;
	public String getId() {
		return id;
	}
	public void setId(String id) 
	{
		if(id==null)
			this.id = UUID.randomUUID().toString().substring(2,7);
	
		else
			this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}