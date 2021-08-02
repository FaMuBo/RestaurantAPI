package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entities.Orders;
import com.exampleFinartz.demo.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    public Orders create(Orders orders) {
        Orders save = ordersRepository.save(orders);
        return save;
    }

    public List<Orders> getAll() {
        List<Orders> ordersList = ordersRepository.findAll();
        return ordersList;
    }

    public Orders getById(Long id) {
        Orders orders = ordersRepository.getById(id);
        return orders;
    }

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

    public Orders deleteById(Long id) {
        Orders orders = ordersRepository.getById(id);
        if (orders != null) {
            ordersRepository.deleteById(id);
            return orders;
        }
        return orders;
    }

    public String delete(long id) {
        ordersRepository.deleteById(id);
        return "SUCCESS";
    }
}
