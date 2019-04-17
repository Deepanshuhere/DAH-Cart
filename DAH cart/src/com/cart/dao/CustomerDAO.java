package com.cart.dao;

import java.util.List;

import com.cart.model.Customer;

public interface CustomerDAO 
{
	public int add(Customer customer);
	public Customer findByEmail(String email,String password);
	public Customer findByNumber(long number,String password);
	public int delete(Customer customer);
	public int update(Customer customer,String email);
	public Customer getCustomer(String email);
	public List<Customer> getAllCustomers();
	public boolean checkUser(String email,String answer);
	public int updatePassword(String email,String newPassword);
}