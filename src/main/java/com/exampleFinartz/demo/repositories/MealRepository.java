package com.exampleFinartz.demo.repositories;

import com.exampleFinartz.demo.models.entity.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<MealEntity, Long> {
}
