package com.example.Mango_Restaurant.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mango_Restaurant.Model.ItemLine;

@Repository
public interface ItemLineRepository extends JpaRepository<ItemLine, Long> {

}

