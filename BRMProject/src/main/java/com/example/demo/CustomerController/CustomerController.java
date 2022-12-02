package com.example.demo.CustomerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CustomerPojo.Customer;
import com.example.demo.CustomerService.CustomerService;
import com.example.demo.businessexception.BusinessException;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/svecustomer")
	public ResponseEntity<Customer> savedata(@RequestBody Customer customer){
		if(customer.getName().isEmpty()|customer.getName().isBlank() | customer.getAddress().isEmpty()|customer.getAddress().isBlank()) {
			throw new BusinessException("fileds are empty",HttpStatus.BAD_REQUEST);
		}else {
		Customer customer3=customerService.Datasave(customer);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(customer3);
	}}
	
	
	@DeleteMapping("/delete/{id}")
	public void  deletedata(@PathVariable ("id") Integer id){
		 customerService.deleteData(id);
		 
		
	}
	
	
}
