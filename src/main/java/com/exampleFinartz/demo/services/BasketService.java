package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entities.Basket;
import com.exampleFinartz.demo.repositories.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {

    @Autowired
    private BasketRepository basketRepository;

    public Basket create(Basket basket) {
        Basket save = basketRepository.save(basket);
        return save;
    }

    public List<Basket> getAll() {
        List<Basket> baskets = basketRepository.findAll();
        return baskets;
    }

    public Basket getById(Long id) {
        Basket basket = basketRepository.getById(id);
        return basket;
    }

    public Basket update(Basket basket) {
        Basket foundBasket = basketRepository.getById(basket.getId());
        if (basket.getTotalPrice() != null) {
            foundBasket.setTotalPrice(basket.getTotalPrice());
        }
        return basketRepository.save(basket);
    }

    public Basket deleteById(Long id) {
        Basket basket = basketRepository.getById(id);
        if (basket != null) {
            basketRepository.deleteById(id);
            return basket;
        }
        return basket;
    }

    public String delete(long id) {
        basketRepository.deleteById(id);
        return "SUCCESS";
    }
}
