package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.entities.Basket;
import com.exampleFinartz.demo.repositories.BasketRepository;
import com.exampleFinartz.demo.services.BasketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;

    public BasketServiceImpl(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @Override
    public Basket create(Basket basket) {
        Basket save = basketRepository.save(basket);
        return save;
    }

    @Override
    public List<Basket> getAll() {
        List<Basket> baskets = basketRepository.findAll();
        return baskets;
    }

    @Override
    public Basket getById(Long id) {
        Basket basket = basketRepository.getById(id);
        return basket;
    }

    @Override
    public Basket update(Basket basket) {
        Basket foundBasket = basketRepository.getById(basket.getId());
        if (basket.getTotalPrice() != null) {
            foundBasket.setTotalPrice(basket.getTotalPrice());
        }
        return basketRepository.save(basket);
    }

    @Override
    public Basket deleteById(Long id) {
        Basket basket = basketRepository.getById(id);
        if (basket != null) {
            basketRepository.deleteById(id);
            return basket;
        }
        return basket;
    }

    @Override
    public String delete(Long id) {
        basketRepository.deleteById(id);
        return "SUCCESS";
    }
}


