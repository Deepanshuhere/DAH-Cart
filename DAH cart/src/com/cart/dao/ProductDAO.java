package com.cart.dao;

import java.util.List;

import com.cart.model.Product;
import com.cart.model.Sales;

public interface ProductDAO 
{
	public int add(Product product);
	public int delete(int id);
	public int update(Product product);
	public Product getProduct(int id);
	public List<Product> getProducts(int categoryId);
	public List<Product> getAllProducts();
	public int addSales(Sales sales);
	public List<Sales> getSales();
}