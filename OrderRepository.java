package com.database.onlinefood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.database.onlinefood.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
