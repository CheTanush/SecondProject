package com.example.demo.CustomerRepository;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.CustomerPojo.Customer;
@Repository
public interface CustomerRepo extends CrudRepository<Customer, Serializable> {

public List<Customer> findAll(); //all customer data in list

public Customer findByName(String name);//finding the data by name

@Transactional
@Modifying
@Query(value="Update brmdetail b set name=?1 , address=?2 where name=?3",nativeQuery = true)	
public void updateData(String name,String address1,String name1);
}
