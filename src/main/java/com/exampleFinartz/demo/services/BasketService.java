package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entity.Basket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BasketService {

    public Basket create(Basket basket);

    public List<Basket> getAll();

    public Basket getById(Long id);

    public Basket update(Basket basket);

    public Basket deleteById(Long id);

    String delete(Long id);
}


