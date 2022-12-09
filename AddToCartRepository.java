package com.database.onlinefood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.database.onlinefood.entity.AddToCart;

@Repository
public interface AddToCartRepository extends JpaRepository<AddToCart, Integer>{

}
