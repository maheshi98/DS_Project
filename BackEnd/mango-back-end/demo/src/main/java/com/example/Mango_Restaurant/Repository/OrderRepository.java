package com.example.Mango_Restaurant.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Mango_Restaurant.Model.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}
