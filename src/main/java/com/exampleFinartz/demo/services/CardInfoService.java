package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.models.entity.CardInfoEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardInfoService {
    public CardInfoEntity create(CardInfoEntity CardInfoEntity);

    public List<CardInfoEntity> getAll();

    public CardInfoEntity getById(Long id);

    public CardInfoEntity update(CardInfoEntity CardInfoEntity);

    public CardInfoEntity deleteById(Long id);

    String delete(Long id);
}

