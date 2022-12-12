package com.database.onlinefood.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.onlinefood.entity.AddToCart;
import com.database.onlinefood.entity.Customer;
import com.database.onlinefood.entity.Menu;
import com.database.onlinefood.entity.Order;
import com.database.onlinefood.repository.MenuRepository;
import com.database.onlinefood.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderrep;
	
	@Autowired
	private MenuRepository menurepo;
	
	public Order showMyOrder(Integer orderid) {
		Optional<Order> order=orderrep.findById(orderid);
		return order.isPresent()? order.get():null;
	}

	public double billAmount(List<AddToCart> cart) {
		
		double totalAmount=0;
		double singleAmount=0;
		int availableQuantity=0;
			
		for(AddToCart cartItem : cart)
		{
			Integer menuid=cartItem.getMenuid();
			Optional<Menu> menu=menurepo.findById(menuid);
			
			if(menu.isPresent())
			{
				Menu menu1= menu.get();
				
				if(menu1.getAvailableQuantity() < cartItem.getQuantity())
				{
					singleAmount=menu1.getAvailableQuantity() * menu1.getPrice();
					cartItem.setQuantity(menu1.getAvailableQuantity());
				}
				else {
					singleAmount=cartItem.getQuantity() * menu1.getPrice();
					availableQuantity=menu1.getAvailableQuantity()-cartItem.getQuantity();
				}
				
				totalAmount=totalAmount + singleAmount;
				menu1.setAvailableQuantity(availableQuantity);
				availableQuantity=0;
				
				cartItem.setFoodname(menu1.getFoodname());
				cartItem.setAmount(singleAmount);
				menurepo.save(menu1);
			}
		}
		return totalAmount;
	}

	public Order saveOrder(Order order) {
		
		return orderrep.save(order);
	}

	public void cancelOrder(Integer orderid) {
		orderrep.deleteById(orderid);
		
	}

	
	
}
