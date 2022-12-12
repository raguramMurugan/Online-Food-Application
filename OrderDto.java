package com.database.onlinefood.dto;

import java.util.List;

import com.database.onlinefood.entity.AddToCart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDto {
	
	private String suggestion;
	private List<AddToCart> cart;
	
	private String username;
	private String password;
	

}
