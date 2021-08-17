//package com.exampleFinartz.demo.ServiceTest;
//
//
//import com.exampleFinartz.demo.models.entity.OrdersEntity;
//import com.exampleFinartz.demo.repositories.OrdersRepository;
//import com.exampleFinartz.demo.services.OrdersService;
//import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@RunWith(MockitoJUnitRunner.class)
//public class OrdersEntityServiceTest {
//    @InjectMocks
//    private OrdersService orderService;
//    @Mock
//    private OrdersRepository ordersRepository;
//
//    @Test
//    public void ReturnAllOrder() {
//        OrdersEntity order1 = OrdersEntity.builder().id(1l).build();
//        OrdersEntity order2 = OrdersEntity.builder().id(2l).build();
//        List<OrdersEntity> commentList = Arrays.asList(order1, order2);
//        Mockito.when(ordersRepository.findAll()).thenReturn(commentList);
//        List<OrdersEntity> fetchedList = orderService.getAll();
//        assertEquals(commentList.size(), fetchedList.size());
//    }
//
//    @Test
//    public void ReturnOrder() {
//        OrdersEntity ordersEntity = OrdersEntity.builder().amount(3).build();
//        Mockito.when(ordersRepository.getById(1L)).thenReturn(ordersEntity);
//        OrdersEntity fetchedOrder = orderService.getById(1L);
//        assertEquals(ordersEntity.getId(), fetchedOrder.getId());
//    }
//
//    @Test
//    public void ReturnSavedOrder() {
//        OrdersEntity order = OrdersEntity.builder().amount(2).build();
//        Mockito.doReturn(order).when(ordersRepository).save(order);
//        OrdersEntity returnedOrder = orderService.create(order);
//        assertEquals(order.getAmount(), returnedOrder.getAmount());
//    }
//
//    @Test
//    public void ReturnUpdatedOrder() {
//        OrdersEntity existOrder = OrdersEntity.builder().id(1L).amount(2).build();
//        OrdersEntity newOrder = OrdersEntity.builder().id(1L).amount(3).build();
//        Mockito.when(ordersRepository.getById(1L)).thenReturn(existOrder);
//        Mockito.when(ordersRepository.save(newOrder)).thenReturn(newOrder);
//        OrdersEntity updatedOrder = orderService.update(newOrder);
//        Assertions.assertNotEquals(existOrder.getAmount(), 2);
//        Assertions.assertEquals(existOrder.getAmount(), 3);
//    }
//}
