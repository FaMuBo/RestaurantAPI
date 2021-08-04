package com.exampleFinartz.demo.ServiceTest;


import com.exampleFinartz.demo.entities.Orders;
import com.exampleFinartz.demo.repositories.OrdersRepository;
import com.exampleFinartz.demo.services.OrdersService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class OrdersServiceTest {
    @InjectMocks
    private OrdersService orderService;
    @Mock
    private OrdersRepository ordersRepository;

    @Test
    public void ReturnAllOrder() {
        Orders order1 = Orders.builder().id(1l).build();
        Orders order2 = Orders.builder().id(2l).build();
        List<Orders> commentList = Arrays.asList(order1, order2);
        Mockito.when(ordersRepository.findAll()).thenReturn(commentList);
        List<Orders> fetchedList = orderService.getAll();
        assertEquals(commentList.size(), fetchedList.size());
    }

    @Test
    public void ReturnOrder() {
        Orders orders = Orders.builder().amount(3).build();
        Mockito.when(ordersRepository.getById(1L)).thenReturn(orders);
        Orders fetchedOrder = orderService.getById(1L);
        assertEquals(orders.getId(), fetchedOrder.getId());
    }

    @Test
    public void ReturnSavedOrder() {
        Orders order = Orders.builder().amount(2).build();
        Mockito.doReturn(order).when(ordersRepository).save(order);
        Orders returnedOrder = orderService.create(order);
        assertEquals(order.getAmount(), returnedOrder.getAmount());
    }

    @Test
    public void ReturnUpdatedOrder() {
        Orders existOrder = Orders.builder().id(1L).amount(2).build();
        Orders newOrder = Orders.builder().id(1L).amount(3).build();
        Mockito.when(ordersRepository.getById(1L)).thenReturn(existOrder);
        Mockito.when(ordersRepository.save(newOrder)).thenReturn(newOrder);
        Orders updatedOrder = orderService.update(newOrder);
        Assertions.assertNotEquals(existOrder.getAmount(), 2);
        Assertions.assertEquals(existOrder.getAmount(), 3);
    }
}
