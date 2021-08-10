package com.exampleFinartz.demo.repositories;


import com.exampleFinartz.demo.models.entity.BasketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<BasketEntity, Long> {
    List<BasketEntity> findAll();

    BasketEntity save(BasketEntity basketEntity);

    BasketEntity getById(Long id);

    void deleteById(Long id);
}