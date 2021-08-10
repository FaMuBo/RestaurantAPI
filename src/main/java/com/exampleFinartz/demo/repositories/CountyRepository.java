package com.exampleFinartz.demo.repositories;

import com.exampleFinartz.demo.models.entity.CountyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountyRepository extends JpaRepository<CountyEntity, Long> {
}
