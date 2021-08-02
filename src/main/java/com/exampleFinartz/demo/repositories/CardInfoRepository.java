package com.exampleFinartz.demo.repositories;

import com.exampleFinartz.demo.entities.CardInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardInfoRepository extends JpaRepository<CardInfo, Long> {
}

