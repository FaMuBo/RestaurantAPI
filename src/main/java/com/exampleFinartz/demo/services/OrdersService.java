package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entity.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrdersService {

    public Orders create(Orders orders);

    public List<Orders> getAll();

    public Orders getById(Long id);

    public Orders update(Orders orders);

    public Orders deleteById(Long id);

    String delete(Long id);

}