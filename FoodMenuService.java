package com.database.onlinefood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.onlinefood.entity.Menu;
import com.database.onlinefood.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	private MenuRepository menurepo;

	public List<Menu> showMenuCard() {
	
		return menurepo.findAll();
	}
	

}
