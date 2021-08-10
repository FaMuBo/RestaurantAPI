package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.models.entity.BasketEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BasketService {

    public BasketEntity create(BasketEntity basketEntity);

    public List<BasketEntity> getAll();

    public BasketEntity getById(Long id);

    public BasketEntity update(BasketEntity basketEntity);

    public BasketEntity deleteById(Long id);

    String delete(Long id);
}


