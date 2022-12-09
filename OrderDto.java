package com.database.onlinefood.dto;

import java.util.List;

import com.database.onlinefood.entity.AddToCart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
	
	private String description;
	private List<AddToCart> cart;
	private String email;
	private String username;
	
}
