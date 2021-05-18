package com.example.Mango_Restaurant.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mango_Restaurant.Model.Checkout;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Long>{

}
