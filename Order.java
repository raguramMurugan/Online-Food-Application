package com.database.onlinefood.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "myorder")
public class Order {

	public Order(Customer customer, String suggestion, List<AddToCart> cart) {
		this.customer=customer;
		this.cart=cart;
		this.suggestion=suggestion;
		
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderid")
	private Integer orderid;
	@Column(name = "suggestion")
	private String suggestion;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<AddToCart> cart;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn
	private Customer customer;
}
