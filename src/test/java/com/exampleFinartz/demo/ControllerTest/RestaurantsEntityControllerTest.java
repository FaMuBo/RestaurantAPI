package com.exampleFinartz.demo.ControllerTest;

import com.exampleFinartz.demo.controllers.RestaurantsController;
import com.exampleFinartz.demo.models.entity.RestaurantsEntity;
import com.exampleFinartz.demo.repositories.RestaurantsRepository;
import com.exampleFinartz.demo.services.RestaurantsService;
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
@WebMvcTest(value = RestaurantsController.class)
public class RestaurantsEntityControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    RestaurantsService restaurantsService;
    @MockBean
    RestaurantsRepository restaurantsRepository;

    String mapToJson(Object o) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(o);
    }

    @Test
    public void add() throws Exception {
        RestaurantsEntity restaurantsEntity = this.generateRestaurants();
        String URI = "/restaurants";
        String inputJson = this.mapToJson(restaurantsEntity);
        Mockito.when(restaurantsService.update(Mockito.any(RestaurantsEntity.class))).thenReturn(restaurantsEntity);
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
        List<RestaurantsEntity> restaurantsEntityList = new ArrayList<>();
        restaurantsEntityList.add(this.generateRestaurants());
        String URI = "/restaurants";
        String inputJson = this.mapToJson(restaurantsEntityList);
        Mockito.when(restaurantsService.getAll()).thenReturn(restaurantsEntityList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);
        Assertions.assertThat(inputJson).isEqualTo(outputJson);
    }

    @Test
    public void getById() throws Exception {
        RestaurantsEntity restaurantsEntity = this.generateRestaurants();
        String URI = "/restaurants/25";
        String inputJson = this.mapToJson(restaurantsEntity);
        Mockito.when(restaurantsService.getById(Mockito.anyLong())).thenReturn(restaurantsEntity);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);
        Assertions.assertThat(inputJson).isEqualTo(outputJson);
    }

    @Test
    public void update() throws Exception {
        RestaurantsEntity restaurantsEntity = this.generateRestaurants();
        String URI = "/restaurants";
        String inputJson = this.mapToJson(restaurantsEntity);
        Mockito.when(restaurantsService.update(Mockito.any(RestaurantsEntity.class))).thenReturn(restaurantsEntity);
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
    public void delete() throws Exception {
        RestaurantsEntity restaurantsEntity = this.generateRestaurants();
        String URI = "/restaurants/9";
        Mockito.when(restaurantsService.delete(Mockito.anyLong())).thenReturn("success");
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete(URI)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);
        Assertions.assertThat("").isEqualTo(outputJson);
    }

    private RestaurantsEntity generateRestaurants() {
        return RestaurantsEntity.builder()
                .name("Hatay Medeniyetler Sofrası")
                .build();
    }
}