package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.models.entity.OrdersEntity;
import com.exampleFinartz.demo.repositories.OrdersRepository;
import com.exampleFinartz.demo.services.OrdersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {


    private OrdersRepository ordersRepository;

    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public OrdersEntity create(OrdersEntity ordersEntity) {
        OrdersEntity save = ordersRepository.save(ordersEntity);
        return save;
    }

    @Override
    public List<OrdersEntity> getAll() {
        List<OrdersEntity> ordersEntityList = ordersRepository.findAll();
        return ordersEntityList;
    }

    @Override
    public OrdersEntity getById(Long id) {
        OrdersEntity ordersEntity = ordersRepository.getById(id);
        return ordersEntity;
    }

    @Override
    public OrdersEntity update(OrdersEntity ordersEntity) {
        OrdersEntity foundOrder = ordersRepository.getById(ordersEntity.getId());
        if (ordersEntity.getAmount() != 0) {
            foundOrder.setAmount(ordersEntity.getAmount());
        }
        if (ordersEntity.getBasketEntity() != null) {
            foundOrder.setBasketEntity(ordersEntity.getBasketEntity());
        }
        if (ordersEntity.getDate() != null) {
            foundOrder.setDate(ordersEntity.getDate());
        }
        return ordersRepository.save(ordersEntity);
    }

    @Override
    public OrdersEntity deleteById(Long id) {
        OrdersEntity ordersEntity = ordersRepository.getById(id);
        if (ordersEntity != null) {
            ordersRepository.deleteById(id);
            return ordersEntity;
        }
        return ordersEntity;
    }

    @Override
    public String delete(Long id) {
        ordersRepository.deleteById(id);
        return "SUCCESS";
    }
}
