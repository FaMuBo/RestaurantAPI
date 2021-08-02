package com.exampleFinartz.demo.repositories;


import com.exampleFinartz.demo.entities.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {
    List<Basket> findAll();

    Basket save(Basket basket);

    Basket getById(Long id);

    void deleteById(Long id);
}