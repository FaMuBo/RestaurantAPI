package com.exampleFinartz.demo.ControllerTest;

import com.exampleFinartz.demo.controllers.BasketController;
import com.exampleFinartz.demo.models.entity.BasketEntity;
import com.exampleFinartz.demo.models.entity.UserEntity;
import com.exampleFinartz.demo.repositories.BasketRepository;
import com.exampleFinartz.demo.services.BasketService;
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
@WebMvcTest(value = BasketController.class)
public class BasketEntityControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private BasketService basketService;

    @MockBean
    private BasketRepository basketRepository;

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    @Test
    public void addBasket() throws Exception {

        BasketEntity basketEntity = this.generateBasket();

        String URI = "/basket";
        String inputJson = this.mapToJson(basketEntity);

        Mockito.when(basketService.create(Mockito.any(BasketEntity.class))).thenReturn(basketEntity);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertThat(inputJson).isEqualTo(outputJson);

    }

    @Test
    public void getAllBasket() throws Exception {

        List<BasketEntity> basketEntityList = new ArrayList<>();
        basketEntityList.add(this.generateBasket());

        String URI = "/basket";
        String inputJson = this.mapToJson(basketEntityList);

        Mockito.when(basketService.getAll()).thenReturn(basketEntityList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertThat(inputJson).isEqualTo(outputJson);

    }

    @Test
    public void getBasketById() throws Exception {

        BasketEntity basketEntity = this.generateBasket();

        String URI = "/basket/2";
        String inputJson = this.mapToJson(basketEntity);

        Mockito.when(basketService.getById(Mockito.anyLong())).thenReturn(basketEntity);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertThat(inputJson).isEqualTo(inputJson);
    }

    @Test
    public void updateBasket() throws Exception {

        BasketEntity basketEntity = this.generateBasket();

        String URI = "/basket";
        String inputJson = this.mapToJson(basketEntity);

        Mockito.when(basketService.update(Mockito.any(BasketEntity.class))).thenReturn(basketEntity);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertThat(inputJson).isEqualTo(outputJson);
    }

    @Test
    public void deleteBasket() throws Exception {

        BasketEntity basketEntity = this.generateBasket();

        String URI = "/basket/4";

        Mockito.when(basketService.delete(Mockito.anyLong())).thenReturn("success");

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete(URI)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertThat("").isEqualTo(outputJson);
    }

    private BasketEntity generateBasket() {

        return BasketEntity.builder()
                .userEntity(UserEntity.builder().name("testname").build())
                .totalPrice(15.25)
                .build();

    }
}