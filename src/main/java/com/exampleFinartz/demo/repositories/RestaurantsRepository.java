package com.exampleFinartz.demo.repositories;

import com.exampleFinartz.demo.models.entity.RestaurantsEntity;
import com.exampleFinartz.demo.models.enums.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantsRepository extends JpaRepository<RestaurantsEntity, Long> {
    List<RestaurantsEntity> findByPosition(Position position);
}
