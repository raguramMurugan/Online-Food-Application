package com.database.onlinefood.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "myorder")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "description")
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Customer customer;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn
	private List<AddToCart> cart;

}
