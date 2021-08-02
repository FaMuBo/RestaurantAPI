package com.exampleFinartz.demo.repositories;

import com.exampleFinartz.demo.entities.Restaurants;
import com.exampleFinartz.demo.enums.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantsRepository extends JpaRepository<Restaurants, Long> {
    List<Restaurants> findAllByPosition(Position position);
}
