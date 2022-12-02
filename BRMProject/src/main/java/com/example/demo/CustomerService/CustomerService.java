package com.example.demo.CustomerService;

import com.example.demo.CustomerPojo.Customer;

public interface CustomerService {

	public Customer Datasave(Customer customer);
	
	public void  deleteData(Integer id);
}
