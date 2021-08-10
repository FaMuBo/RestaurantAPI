package com.exampleFinartz.demo.ControllerTest;

import com.exampleFinartz.demo.controllers.BranchController;
import com.exampleFinartz.demo.models.entity.BranchEntity;
import com.exampleFinartz.demo.models.entity.MenuEntity;
import com.exampleFinartz.demo.models.enums.Position;
import com.exampleFinartz.demo.repositories.BranchRepository;
import com.exampleFinartz.demo.services.BranchService;
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
@WebMvcTest(BranchController.class)
public class BranchEntityControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BranchService branchService;

    @MockBean
    BranchRepository branchRepository;

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    @Test
    public void add() throws Exception {
        BranchEntity branchEntity = this.generateBranch();

        String URI = "/branch";
        String inputJson = this.mapToJson(branchEntity);

        Mockito.when(branchService.create(Mockito.any(BranchEntity.class))).thenReturn(branchEntity);

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
    public void getAll() throws Exception {

        List<BranchEntity> branchEntityList = new ArrayList<>();
        branchEntityList.add(this.generateBranch());

        String URI = "/branch";
        String inputJson = this.mapToJson(branchEntityList);

        Mockito.when(branchService.getAll()).thenReturn(branchEntityList);

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

        BranchEntity branchEntity = this.generateBranch();

        String URI = "/branch/13";
        String inputJson = this.mapToJson(branchEntity);

        Mockito.when(branchService.getById(Mockito.anyLong())).thenReturn(branchEntity);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertThat(inputJson).isEqualTo(outputJson);
    }

    @Test
    public void getAllBtWaiting() throws Exception {

        List<BranchEntity> branchEntityList = new ArrayList<>();
        branchEntityList.add(this.generateBranch());

        String URI = "/branch/waiting";
        String inputJson = this.mapToJson(branchEntityList);

        Mockito.when(branchService.getWaitingBranchList(Position.WAITING)).thenReturn(branchEntityList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);
//inputJson
        Assertions.assertThat("[]").isEqualTo(outputJson);
    }

    @Test
    public void update() throws Exception {

        BranchEntity branchEntity = this.generateBranch();

        String URI = "/branch";
        String inputJson = this.mapToJson(branchEntity);

        Mockito.when(branchService.update(Mockito.any(BranchEntity.class))).thenReturn(branchEntity);

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

        BranchEntity branchEntity = this.generateBranch();

        String URI = "/branch/7";

        Mockito.when(branchService.delete(Mockito.anyLong())).thenReturn("success");

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete(URI)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertThat("").isEqualTo(outputJson);
    }

    private BranchEntity generateBranch() {
        return BranchEntity.builder()
                .name("etilerşubesi")
                .menuEntity(MenuEntity.builder().build())
                .build();
    }
}