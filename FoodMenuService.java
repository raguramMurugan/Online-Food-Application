package com.database.onlinefood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.onlinefood.entity.FoodMenu;
import com.database.onlinefood.repository.FoodMenuRepository;

@Service
public class FoodMenuService {
	
	@Autowired
	FoodMenuRepository foodrepo;

	public List<FoodMenu> getAllMenuList() {
		
		return foodrepo.findAll();
	}
	
}
