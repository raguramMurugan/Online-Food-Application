package com.database.onlinefood.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.database.onlinefood.repository.FoodMenuRepository;

@Service
public class OrderService {
	
	@Autowired
	FoodMenuRepository foodrepo;

}
