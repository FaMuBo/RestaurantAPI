package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.models.entity.BasketEntity;
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
    public BasketEntity create(BasketEntity basketEntity) {
        BasketEntity save = basketRepository.save(basketEntity);
        return save;
    }

    @Override
    public List<BasketEntity> getAll() {
        List<BasketEntity> basketEntities = basketRepository.findAll();
        return basketEntities;
    }

    @Override
    public BasketEntity getById(Long id) {
        BasketEntity basketEntity = basketRepository.getById(id);
        return basketEntity;
    }

    @Override
    public BasketEntity update(BasketEntity basketEntity) {
        BasketEntity foundBasketEntity = basketRepository.getById(basketEntity.getId());
        if (basketEntity.getTotalPrice() != null) {
            foundBasketEntity.setTotalPrice(basketEntity.getTotalPrice());
        }
        return basketRepository.save(basketEntity);
    }

    @Override
    public BasketEntity deleteById(Long id) {
        BasketEntity basketEntity = basketRepository.getById(id);
        if (basketEntity != null) {
            basketRepository.deleteById(id);
            return basketEntity;
        }
        return basketEntity;
    }

    @Override
    public String delete(Long id) {
        basketRepository.deleteById(id);
        return "SUCCESS";
    }
}


