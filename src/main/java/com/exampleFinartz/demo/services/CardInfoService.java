package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entity.CardInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardInfoService {
    public CardInfo create(CardInfo CardInfo);

    public List<CardInfo> getAll();

    public CardInfo getById(Long id);

    public CardInfo update(CardInfo CardInfo);

    public CardInfo deleteById(Long id);

    String delete(Long id);
}

