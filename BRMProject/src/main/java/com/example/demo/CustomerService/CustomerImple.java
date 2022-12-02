package com.example.demo.CustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.CustomerPojo.Customer;
import com.example.demo.CustomerRepository.CustomerRepo;
import com.example.demo.businessexception.BusinessException;

@Service
public class CustomerImple implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	PasswordEncoder passwordEncoder;
	
	public CustomerImple(CustomerRepo customerRepo) {
		super();
		this.customerRepo = customerRepo;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	@Override
	public Customer Datasave(Customer customer1) {
		List<Customer> list=customerRepo.findAll();
		long count=0;
		
		for(Customer cust:list) {
			if(customer1.getName().equals(cust.getName())){
				count++;
				
			}
					
			}if(count==0) {
				String add=this.passwordEncoder.encode(customer1.getAddress());
				customer1.setAddress(add);
				Customer customer2=customerRepo.save(customer1);
				return customer2;
			}else {
				throw new BusinessException("data is already present",HttpStatus.ALREADY_REPORTED);
			}
	}
		
		

	
	@Override
	public void deleteData(Integer id ) {
		
		customerRepo.deleteById(id);
	}

}