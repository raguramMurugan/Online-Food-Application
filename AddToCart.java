package com.database.onlinefood.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "add_to_cart")
public class AddToCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartid")
	private Integer cartid;
	@Column(name = "menuid")
	private Integer menuid;
	@Column(name = "foodname")
	private String foodname;
	@Column(name = "quantity")
	private Integer quantity;
	@Column(name = "amount")
	private double amount;
}
