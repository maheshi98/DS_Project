package com.example.Mango_Restaurant.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.Mango_Restaurant.Model.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Integer> {

}
