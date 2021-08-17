//package com.exampleFinartz.demo.ControllerTest;
//
//import com.exampleFinartz.demo.controllers.CommentsController;
//import com.exampleFinartz.demo.models.entity.BranchEntity;
//import com.exampleFinartz.demo.models.entity.CommentsEntity;
//import com.exampleFinartz.demo.repositories.CommentsRepository;
//import com.exampleFinartz.demo.services.CommentsService;
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
//@WebMvcTest(value = CommentsController.class)
//public class CommentsEntityControllerTest {
//    @Autowired
//    MockMvc mockMvc;
//    @MockBean
//    CommentsService commentsService;
//    @MockBean
//    CommentsRepository commentsRepository;
//
//    String mapToJson(Object o) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.writeValueAsString(o);
//    }
//
//    @Test
//    public void add() throws Exception {
//        CommentsEntity commentsEntity = this.generateComments();
//        String URI = "/comments";
//        String inputJson = this.mapToJson(commentsEntity);
//        Mockito.when(commentsService.update(Mockito.any(CommentsEntity.class))).thenReturn(commentsEntity);
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
//        List<CommentsEntity> commentsEntityList = new ArrayList<>();
//        commentsEntityList.add(this.generateComments());
//        String URI = "/comments";
//        String inputJson = this.mapToJson(commentsEntityList);
//        Mockito.when(commentsService.getAll()).thenReturn(commentsEntityList);
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
//        CommentsEntity commentsEntity = this.generateComments();
//        String URI = "/comments/13";
//        String inputJson = this.mapToJson(commentsEntity);
//        Mockito.when(commentsService.getById(Mockito.anyLong())).thenReturn(commentsEntity);
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
//        CommentsEntity commentsEntity = this.generateComments();
//        String URI = "/comment";
//        String inputJson = this.mapToJson(commentsEntity);
//        Mockito.when(commentsService.update(Mockito.any(CommentsEntity.class))).thenReturn(commentsEntity);
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
//        CommentsEntity commentsEntity = this.generateComments();
//        String URI = "/comments/7";
//        Mockito.when(commentsService.delete(Mockito.anyLong())).thenReturn("success");
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .delete(URI)
//                .accept(MediaType.APPLICATION_JSON);
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);
//        Assertions.assertThat("").isEqualTo(outputJson);
//    }
//
//    private CommentsEntity generateComments() {
//        return CommentsEntity.builder()
//                .branchEntity(BranchEntity.builder().name("etilerşubesi").build())
//                .build();
//    }
//}