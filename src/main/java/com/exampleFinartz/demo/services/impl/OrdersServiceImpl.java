package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.entity.Orders;
import com.exampleFinartz.demo.repositories.OrdersRepository;
import com.exampleFinartz.demo.services.OrdersService;

import java.util.List;

public class OrdersServiceImpl implements OrdersService {


    private OrdersRepository ordersRepository;

    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public Orders create(Orders orders) {
        Orders save = ordersRepository.save(orders);
        return save;
    }

    @Override
    public List<Orders> getAll() {
        List<Orders> ordersList = ordersRepository.findAll();
        return ordersList;
    }

    @Override
    public Orders getById(Long id) {
        Orders orders = ordersRepository.getById(id);
        return orders;
    }

    @Override
    public Orders update(Orders orders) {
        Orders foundOrder = ordersRepository.getById(orders.getId());
        if (orders.getAmount() != 0) {
            foundOrder.setAmount(orders.getAmount());
        }
        if (orders.getBasket() != null) {
            foundOrder.setBasket(orders.getBasket());
        }
        if (orders.getDate() != null) {
            foundOrder.setDate(orders.getDate());
        }
        return ordersRepository.save(orders);
    }

    @Override
    public Orders deleteById(Long id) {
        Orders orders = ordersRepository.getById(id);
        if (orders != null) {
            ordersRepository.deleteById(id);
            return orders;
        }
        return orders;
    }

    @Override
    public String delete(Long id) {
        ordersRepository.deleteById(id);
        return "SUCCESS";
    }
}
