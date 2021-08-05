package com.exampleFinartz.demo.ControllerTest;

import com.exampleFinartz.demo.controllers.RestaurantsController;
import com.exampleFinartz.demo.entity.Restaurants;
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
public class RestaurantsControllerTest {
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
        Restaurants restaurants = this.generateRestaurants();
        String URI = "/restaurants";
        String inputJson = this.mapToJson(restaurants);
        Mockito.when(restaurantsService.update(Mockito.any(Restaurants.class))).thenReturn(restaurants);
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
        List<Restaurants> restaurantsList = new ArrayList<>();
        restaurantsList.add(this.generateRestaurants());
        String URI = "/restaurants";
        String inputJson = this.mapToJson(restaurantsList);
        Mockito.when(restaurantsService.getAll()).thenReturn(restaurantsList);
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
        Restaurants restaurants = this.generateRestaurants();
        String URI = "/restaurants/25";
        String inputJson = this.mapToJson(restaurants);
        Mockito.when(restaurantsService.getById(Mockito.anyLong())).thenReturn(restaurants);
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
        Restaurants restaurants = this.generateRestaurants();
        String URI = "/restaurants";
        String inputJson = this.mapToJson(restaurants);
        Mockito.when(restaurantsService.update(Mockito.any(Restaurants.class))).thenReturn(restaurants);
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
        Restaurants restaurants = this.generateRestaurants();
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

    private Restaurants generateRestaurants() {
        return Restaurants.builder()
                .name("Hatay Medeniyetler Sofrası")
                .build();
    }
}