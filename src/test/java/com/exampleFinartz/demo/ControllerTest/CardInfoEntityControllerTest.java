//package com.exampleFinartz.demo.ControllerTest;
//
//import com.exampleFinartz.demo.controllers.CardInfoController;
//import com.exampleFinartz.demo.models.entity.CardInfoEntity;
//import com.exampleFinartz.demo.repositories.CardInfoRepository;
//import com.exampleFinartz.demo.services.CardInfoService;
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
//@WebMvcTest(value = CardInfoController.class)
//
//public class CardInfoEntityControllerTest {
//    @Autowired
//    MockMvc mockMvc;
//    @MockBean
//    CardInfoService cardInfoService;
//    @MockBean
//    CardInfoRepository cardInfoRepository;
//
//    String mapToJson(Object o) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.writeValueAsString(o);
//    }
//
//    @Test
//    public void add() throws Exception {
//        CardInfoEntity cardInfoEntity = this.generateCardInfo();
//        String URI = "/C-cardsInfo";
//        String inputJson = this.mapToJson(cardInfoEntity);
//        Mockito.when(cardInfoService.update(Mockito.any(CardInfoEntity.class))).thenReturn(cardInfoEntity);
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
//        List<CardInfoEntity> cardInfoEntityList = new ArrayList<>();
//        cardInfoEntityList.add(this.generateCardInfo());
//        String URI = "/cardsInfo";
//        String inputJson = this.mapToJson(cardInfoEntityList);
//        Mockito.when(cardInfoService.getAll()).thenReturn(cardInfoEntityList);
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
//        CardInfoEntity cardInfoEntity = this.generateCardInfo();
//        String URI = "/CardsInfo/25";
//        String inputJson = this.mapToJson(cardInfoEntity);
//        Mockito.when(cardInfoService.getById(Mockito.anyLong())).thenReturn(cardInfoEntity);
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
//        CardInfoEntity cardInfoEntity = this.generateCardInfo();
//        String URI = "/cardsInfo";
//        String inputJson = this.mapToJson(cardInfoEntity);
//        Mockito.when(cardInfoService.update(Mockito.any(CardInfoEntity.class))).thenReturn(cardInfoEntity);
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
//        CardInfoEntity cardsInfo = this.generateCardInfo();
//        String URI = "/cardsInfo/9";
//        Mockito.when(cardInfoService.delete(Mockito.anyLong())).thenReturn("success");
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .delete(URI)
//                .accept(MediaType.APPLICATION_JSON);
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);
//        Assertions.assertThat("").isEqualTo(outputJson);
//    }
//
//    private CardInfoEntity generateCardInfo() {
//        return CardInfoEntity.builder()
//                .name("Ziraat")
//                .build();
//    }
//}