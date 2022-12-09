package com.database.onlinefood.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class FoodMenu {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "food_name")
	private String foodName;
	@Column(name = "available_quantity")
	private int availableQuantity;
	@Column(name = "price")
	private double price;


	
}
