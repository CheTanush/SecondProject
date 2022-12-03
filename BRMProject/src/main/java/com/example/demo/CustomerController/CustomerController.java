package com.example.demo.CustomerController;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CustomerPojo.Customer;
import com.example.demo.CustomerService.CustomerService;
import com.example.demo.businessexception.BusinessException;

@RestController
public class CustomerController {
	
	private final static org.slf4j.Logger log=LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/svecustomer")
	public ResponseEntity<Customer> savedata(@RequestBody Customer customer4){
		
		log.info("Customer Service implementation : DataSave() method");
		
		if(customer4.getName().isEmpty()|customer4.getName().isBlank() | customer4.getAddress().isEmpty()|customer4.getAddress().isBlank()) {
			throw new BusinessException("fileds are empty",HttpStatus.BAD_REQUEST);
		}else {
		Customer customer3=customerService.Datasave(customer4);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(customer3);
	}}
	
	
	@DeleteMapping("/delete/{id}")
	public void  deletedata(@PathVariable ("id") Integer id){
		log.info("Customer Service delete data : deleteData() method");
		 customerService.deleteData(id);
		 
		
	}
	
	@GetMapping("/getdata/{name}")
	public ResponseEntity<Customer> getdata(@PathVariable("name") String name){
		Customer custt=customerService.getData(name);
		return ResponseEntity.status(HttpStatus.FOUND).body(custt);
		
	}
	
	
}
