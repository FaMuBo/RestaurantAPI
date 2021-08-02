package com.exampleFinartz.demo.ControllerTest;

import com.exampleFinartz.demo.controllers.CardInfoController;
import com.exampleFinartz.demo.entities.CardInfo;
import com.exampleFinartz.demo.repositories.CardInfoRepository;
import com.exampleFinartz.demo.services.CardInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = CardInfoController.class)

public class CardInfoControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    CardInfoService cardInfoService;
    @MockBean
    CardInfoRepository cardInfoRepository;

    String mapToJson(Object o) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(o);
    }

    @Test
    public void add() throws Exception {
        CardInfo cardInfo = this.generateCardInfo();
        String URI = "/C-cardsInfo";
        String inputJson = this.mapToJson(cardInfo);
        Mockito.when(cardInfoService.update(Mockito.any(CardInfo.class))).thenReturn(cardInfo);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_VALUE);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);
        Assertions.assertThat("").isEqualTo(outputJson);
    }

    @Test
    public void getAll() throws Exception {
        List<CardInfo> CardInfoList = new ArrayList<>();
        CardInfoList.add(this.generateCardInfo());
        String URI = "/cardsInfo";
        String inputJson = this.mapToJson(CardInfoList);
        Mockito.when(cardInfoService.getAll()).thenReturn(CardInfoList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);
        Assertions.assertThat("").isEqualTo(outputJson);
    }

    @Test
    public void getById() throws Exception {
        CardInfo cardInfo = this.generateCardInfo();
        String URI = "/CardsInfo/25";
        String inputJson = this.mapToJson(cardInfo);
        Mockito.when(cardInfoService.getById(Mockito.anyLong())).thenReturn(cardInfo);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);
        Assertions.assertThat("").isEqualTo(outputJson);
    }

    @Test
    public void update() throws Exception {
        CardInfo cardInfo = this.generateCardInfo();
        String URI = "/cardsInfo";
        String inputJson = this.mapToJson(cardInfo);
        Mockito.when(cardInfoService.update(Mockito.any(CardInfo.class))).thenReturn(cardInfo);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_VALUE);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);
        Assertions.assertThat("").isEqualTo(outputJson);
    }

    @Test
    public void delete() throws Exception {
        CardInfo cardsInfo = this.generateCardInfo();
        String URI = "/cardsInfo/9";
        Mockito.when(cardInfoService.delete(Mockito.anyLong())).thenReturn("success");
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete(URI)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);
        Assertions.assertThat("").isEqualTo(outputJson);
    }

    private CardInfo generateCardInfo() {
        return CardInfo.builder()
                .name("Ziraat")
                .build();
    }
}