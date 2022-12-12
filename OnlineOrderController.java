package com.database.onlinefood.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.onlinefood.dto.OrderDto;
import com.database.onlinefood.dto.ResponseOrderDto;
import com.database.onlinefood.entity.Customer;
import com.database.onlinefood.entity.Menu;
import com.database.onlinefood.entity.Order;
import com.database.onlinefood.service.CustomerService;
import com.database.onlinefood.service.MenuService;
import com.database.onlinefood.service.OrderService;

@RestController
@RequestMapping("/Kollapasi")
public class OnlineFoodController {
	
	@Autowired
	private MenuService menuservice;
	
	@Autowired
	private OrderService orderservice;
	
	@Autowired
	private CustomerService customerservice;
	
	@GetMapping("/menuCard")
	public List<Menu> showMenuCard()
	{
		return menuservice.showMenuCard();
	}
	
	@GetMapping("/showMyOrder/{orderid}")
	public Order showMyOrder(@PathVariable("orderid") int orderid)
	{
		return orderservice.showMyOrder(orderid);
	}
	
	@PostMapping("/placeOrder")
	public ResponseOrderDto placeOrder(@RequestBody OrderDto orderDto)
	{
		ResponseOrderDto responseOrderDto=new ResponseOrderDto();
		Double amount=orderservice.billAmount(orderDto.getCart());
		
		Customer customer=new Customer(orderDto.getUsername(), orderDto.getPassword());
		Integer customerFromDatabase=customerservice.isCustomerPresentInDatabase(customer);
		
		if(customerFromDatabase!=null)
		{
			customer.setCustomerid(customerFromDatabase);
		}
		else {
			customer=customerservice.saveCustomer(customer);
		}
		Order order=new Order(customer, orderDto.getSuggestion(), orderDto.getCart());
		order=orderservice.saveOrder(order);
		
		responseOrderDto.setTotalamount(amount);
		responseOrderDto.setInvoicenumber(new Random().nextInt(1000));
		responseOrderDto.setOrderid(order.getOrderid());
		responseOrderDto.setSuggestion(orderDto.getSuggestion());
		
		return responseOrderDto;
	}
	
	@DeleteMapping("/cancelOrder/{orderid}")
	public String cancelOrder(@PathVariable("orderid") Integer orderid)
	{
		orderservice.cancelOrder(orderid);
		return "Your Order has Been cancelled and Removed from Cart";
	}
}
