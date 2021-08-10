package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.models.entity.OrdersEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrdersService {

    public OrdersEntity create(OrdersEntity ordersEntity);

    public List<OrdersEntity> getAll();

    public OrdersEntity getById(Long id);

    public OrdersEntity update(OrdersEntity ordersEntity);

    public OrdersEntity deleteById(Long id);

    String delete(Long id);

}