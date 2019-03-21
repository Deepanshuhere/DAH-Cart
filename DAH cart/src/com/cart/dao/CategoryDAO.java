package com.cart.dao;

import java.util.List;

import com.cart.model.Category;

public interface CategoryDAO 
{
	public int add(Category category);
	public int delete(int categoryId);
	public List<Category> getAll();
	//public int getCategoryId(String categoryName);
}