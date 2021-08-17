//package com.exampleFinartz.demo.ControllerTest;
//
//import com.exampleFinartz.demo.controllers.OrdersController;
//import com.exampleFinartz.demo.models.entity.OrdersEntity;
//import com.exampleFinartz.demo.repositories.OrdersRepository;
//import com.exampleFinartz.demo.services.OrdersService;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.assertj.core.api.Assertions;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.List;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebMvcTest(value = OrdersController.class)
//public class OrdersEntityControllerTest {
//    @Autowired
//    MockMvc mockMvc;
//    @MockBean
//    OrdersService ordersService;
//    @MockBean
//    OrdersRepository orderRepository;
//
//    String mapToJson(Object o) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.writeValueAsString(o);
//    }
//
//    @Test
//    public void add() throws Exception {
//        OrdersEntity ordersEntity = this.generateOrders();
//        String URI = "/order";
//        String inputJson = this.mapToJson(ordersEntity);
//        Mockito.when(ordersService.update(Mockito.any(OrdersEntity.class))).thenReturn(ordersEntity);
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .post(URI)
//                .accept(MediaType.APPLICATION_JSON).content(inputJson)
//                .contentType(MediaType.APPLICATION_JSON_VALUE);
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);
//        Assertions.assertThat("").isEqualTo(outputJson);
//    }
//
//    @Test
//    public void getAll() throws Exception {
//        List<OrdersEntity> ordersEntityList = new ArrayList<>();
//        ordersEntityList.add(this.generateOrders());
//        String URI = "/order";
//        String inputJson = this.mapToJson(ordersEntityList);
//        Mockito.when(ordersService.getAll()).thenReturn(ordersEntityList);
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .get(URI)
//                .accept(MediaType.APPLICATION_JSON);
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);
//        Assertions.assertThat("").isEqualTo(outputJson);
//    }
//
//    @Test
//    public void getById() throws Exception {
//        OrdersEntity ordersEntity = this.generateOrders();
//        String URI = "/order/25";
//        String inputJson = this.mapToJson(ordersEntity);
//        Mockito.when(ordersService.getById(Mockito.anyLong())).thenReturn(ordersEntity);
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .get(URI)
//                .accept(MediaType.APPLICATION_JSON);
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);
//        Assertions.assertThat("").isEqualTo(outputJson);
//    }
//
//    @Test
//    public void update() throws Exception {
//        OrdersEntity ordersEntity = this.generateOrders();
//        String URI = "/Order";
//        String inputJson = this.mapToJson(ordersEntity);
//        Mockito.when(ordersService.update(Mockito.any(OrdersEntity.class))).thenReturn(ordersEntity);
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .put(URI)
//                .accept(MediaType.APPLICATION_JSON).content(inputJson)
//                .contentType(MediaType.APPLICATION_JSON_VALUE);
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);
//        Assertions.assertThat("").isEqualTo(outputJson);
//    }
//
//    @Test
//    public void delete() throws Exception {
//        OrdersEntity ordersEntity = this.generateOrders();
//        String URI = "/Order/9";
//        Mockito.when(ordersService.delete(Mockito.anyLong())).thenReturn("success");
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .delete(URI)
//                .accept(MediaType.APPLICATION_JSON);
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);
//        Assertions.assertThat("").isEqualTo(outputJson);
//    }
//
//    private OrdersEntity generateOrders() {
//        return OrdersEntity.builder()
//                .amount(2)
//                .build();
//    }
//}