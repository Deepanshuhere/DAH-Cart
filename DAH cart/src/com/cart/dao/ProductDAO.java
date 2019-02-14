package com.cart.dao;

import java.util.List;

import com.cart.model.Product;

public interface ProductDAO 
{
	public int add(Product product);
	public int delete(String id);
	public int update(Product product);
	public Product getProduct(String id);
	public List<Product> getProducts(String categoryId);
	public List<Product> getAllProducts();
}