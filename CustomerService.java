package com.database.onlinefood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.onlinefood.entity.Customer;
import com.database.onlinefood.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerrepo;

	public Integer isCustomerPresentInDatabase(Customer customer) {
		Customer customer1=customerrepo.findCustomerByUsernameAndPassword(customer.getUsername(), customer.getPassword());
		
		return customer1!=null? customer1.getCustomerid() :null;
	}

	public Customer saveCustomer(Customer customer) {
		
		return customerrepo.save(customer);
		
	}

}
