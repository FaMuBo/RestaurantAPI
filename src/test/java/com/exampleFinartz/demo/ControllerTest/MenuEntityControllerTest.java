//package com.exampleFinartz.demo.ControllerTest;
//
//import com.exampleFinartz.demo.controllers.MenuController;
//import com.exampleFinartz.demo.models.entity.MenuEntity;
//import com.exampleFinartz.demo.repositories.MenuRepository;
//import com.exampleFinartz.demo.services.MenuService;
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
//@WebMvcTest(value = MenuController.class)
//public class MenuEntityControllerTest {
//    @Autowired
//    MockMvc mockMvc;
//    @MockBean
//    MenuService menuService;
//    @MockBean
//    MenuRepository menuRepository;
//
//    String mapToJson(Object o) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.writeValueAsString(o);
//    }
//
//    @Test
//    public void add() throws Exception {
//        MenuEntity menuEntity = this.generateMenu();
//        String URI = "/menu";
//        String inputJson = this.mapToJson(menuEntity);
//        Mockito.when(menuService.update(Mockito.any(MenuEntity.class))).thenReturn(menuEntity);
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
//        List<MenuEntity> menuEntityList = new ArrayList<>();
//        menuEntityList.add(this.generateMenu());
//        String URI = "/menu";
//        String inputJson = this.mapToJson(menuEntityList);
//        Mockito.when(menuService.getAll()).thenReturn(menuEntityList);
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .get(URI)
//                .accept(MediaType.APPLICATION_JSON);
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);
//        Assertions.assertThat(inputJson).isEqualTo(outputJson);
//    }
//
//    @Test
//    public void getById() throws Exception {
//        MenuEntity menuEntity = this.generateMenu();
//        String URI = "/menu/5";
//        String inputJson = this.mapToJson(menuEntity);
//        Mockito.when(menuService.getById(Mockito.anyLong())).thenReturn(menuEntity);
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .get(URI)
//                .accept(MediaType.APPLICATION_JSON);
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);
//        Assertions.assertThat(inputJson).isEqualTo(outputJson);
//    }
//
//    @Test
//    public void update() throws Exception {
//        MenuEntity menuEntity = this.generateMenu();
//        String URI = "/menu";
//        String inputJson = this.mapToJson(menuEntity);
//        Mockito.when(menuService.update(Mockito.any(MenuEntity.class))).thenReturn(menuEntity);
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .put(URI)
//                .accept(MediaType.APPLICATION_JSON).content(inputJson)
//                .contentType(MediaType.APPLICATION_JSON_VALUE);
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);
//        Assertions.assertThat(inputJson).isEqualTo(outputJson);
//    }
//
//    @Test
//    public void delete() throws Exception {
//        MenuEntity menuEntity = this.generateMenu();
//        String URI = "/menu/4";
//        Mockito.when(menuService.delete(Mockito.anyLong())).thenReturn("success");
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .delete(URI)
//                .accept(MediaType.APPLICATION_JSON);
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);
//        Assertions.assertThat("").isEqualTo(outputJson);
//    }
//
//    private MenuEntity generateMenu() {
//        return MenuEntity.builder()
//                .build();
//    }
//}