package com.exampleFinartz.demo.ControllerTest;

import com.exampleFinartz.demo.controllers.MealController;
import com.exampleFinartz.demo.models.entity.MealEntity;
import com.exampleFinartz.demo.repositories.MealRepository;
import com.exampleFinartz.demo.services.MealService;
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
@WebMvcTest(value = MealController.class)
public class MealEntityControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    MealService mealService;
    @MockBean
    MealRepository mealRepository;

    String mapToJson(Object o) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(o);
    }

    @Test
    public void add() throws Exception {
        MealEntity mealEntity = this.generateMeal();
        String URI = "/meal";
        String inputJson = this.mapToJson(mealEntity);
        Mockito.when(mealService.update(Mockito.any(MealEntity.class))).thenReturn(mealEntity);
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
        List<MealEntity> mealEntityList = new ArrayList<>();
        mealEntityList.add(this.generateMeal());
        String URI = "/meal";
        String inputJson = this.mapToJson(mealEntityList);
        Mockito.when(mealService.getAll()).thenReturn(mealEntityList);
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
        MealEntity mealEntity = this.generateMeal();
        String URI = "/meal/11";
        String inputJson = this.mapToJson(mealEntity);
        Mockito.when(mealService.getById(Mockito.anyLong())).thenReturn(mealEntity);
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
        MealEntity mealEntity = this.generateMeal();
        String URI = "/meal";
        String inputJson = this.mapToJson(mealEntity);
        Mockito.when(mealService.update(Mockito.any(MealEntity.class))).thenReturn(mealEntity);
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
        MealEntity mealEntity = this.generateMeal();
        String URI = "/meal/19";
        Mockito.when(mealService.delete(Mockito.anyLong())).thenReturn("success");
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete(URI)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);
        Assertions.assertThat("").isEqualTo(outputJson);
    }

    private MealEntity generateMeal() {
        return MealEntity.builder()
                .name("Kumpir + Kola")
                .build();
    }
}