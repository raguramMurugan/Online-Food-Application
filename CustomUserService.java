package com.database.onlinefood.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.database.onlinefood.entity.Customer;
import com.database.onlinefood.repository.CustomerRepository;

@Service
public class CustomUserService implements UserDetailsService{

	@Autowired
	CustomerRepository repo;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer=repo.findByUsername(username);
		if(customer==null)
		{
			throw new UsernameNotFoundException("No User Found");
		}
		return new CustomUserDetails(customer);
	}

}
