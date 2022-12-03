package com.example.demo.CustomerRepository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.CustomerPojo.Customer;
@Repository
public interface CustomerRepo extends CrudRepository<Customer, Serializable> {

public List<Customer> findAll(); //all customer data in list

public Customer findByName(String name);//finding the data by name

	
}
