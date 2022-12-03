package com.example.demo.CustomerService;

import com.example.demo.CustomerPojo.Customer;

public interface CustomerService {

	public Customer Datasave(Customer customer);//save data in database
	
	public void  deleteData(Integer id);//delete by id using this method
	
	public Customer getData(String name);//get the data by customer name
}
