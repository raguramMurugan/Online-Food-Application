package com.database.onlinefood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


import com.database.onlinefood.entity.FoodMenu;
import com.database.onlinefood.service.FoodMenuService;
import com.database.onlinefood.service.OrderService;

@RestController
public class OnlineOrderController {
	
	@Autowired
	FoodMenuService foodservice;
	
	@Autowired
	OrderService orderservice;
	
	@GetMapping("/getMenuList")
	public List<FoodMenu> getAllMenuList()
	{
		return foodservice.getAllMenuList();
	}
	

	
}
