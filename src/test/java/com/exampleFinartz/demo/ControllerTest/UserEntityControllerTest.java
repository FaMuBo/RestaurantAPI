package com.exampleFinartz.demo.ControllerTest;

import com.exampleFinartz.demo.controllers.UserController;
import com.exampleFinartz.demo.models.entity.UserEntity;
import com.exampleFinartz.demo.models.enums.Role;
import com.exampleFinartz.demo.repositories.UserRepository;
import com.exampleFinartz.demo.services.UserService;
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
@WebMvcTest(value = UserController.class)
public class UserEntityControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;
    @MockBean
    private UserRepository userRepository;

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    @Test
    public void addUser() throws Exception {
        UserEntity userEntity = this.generateUser();
        String URI = "/users";
        String inputJson = this.mapToJson(userEntity);
        Mockito.when(userService.update(Mockito.any(UserEntity.class))).thenReturn(userEntity);
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
    public void getAllUsers() throws Exception {
        List<UserEntity> userEntityList = new ArrayList<>();
        userEntityList.add(this.generateUser());
        String URI = "/users";
        String inputInJson = this.mapToJson(userEntityList);
        Mockito.when(userService.getAll()).thenReturn(userEntityList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputInJson = response.getContentAsString();
        Assertions.assertThat(outputInJson).isEqualTo("");
    }

    @Test
    public void getUserById() throws Exception {
        UserEntity userEntity = this.generateUser();
        String URI = "/users/1";
        String inputJson = this.mapToJson(userEntity);
        Mockito.when(userService.getById(Mockito.anyLong())).thenReturn(userEntity);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String outputJsonValue = result.getResponse().getContentAsString();
        Assertions.assertThat("").isEqualTo(outputJsonValue);
    }

    @Test
    public void getUserByName() throws Exception {
        UserEntity userEntity = this.generateUser();
        String URI = "/users/name/test";
        String inputJson = this.mapToJson(userEntity);
        Mockito.when(userService.getUserByName(Mockito.anyString())).thenReturn(userEntity);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputJsonValue = response.getContentAsString();
        Assertions.assertThat("").isEqualTo(outputJsonValue);
    }

    @Test
    public void updateUsers() throws Exception {
        UserEntity userEntity = this.generateUser();
        String URI = "/users";
        String inputJson = this.mapToJson(userEntity);
        Mockito.when(userService.update(Mockito.any(UserEntity.class))).thenReturn(userEntity);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put(URI)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON).content(this.mapToJson(userEntity));
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputJsonValue = response.getContentAsString();
        Assertions.assertThat("").isEqualTo(outputJsonValue);
    }

    @Test
    public void deleteUser() throws Exception {
        UserEntity userEntity = this.generateUser();
        String URI = "/users/1";
        Mockito.when(userService.delete(Mockito.anyLong())).thenReturn("success");
        RequestBuilder request = MockMvcRequestBuilders
                .delete(URI)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputJsonValue = response.getContentAsString();
        Assertions.assertThat("").isEqualTo(outputJsonValue);
    }

    private UserEntity generateUser() {
        return UserEntity.builder()
                .name("testname")
                .email("test@mail.com")
                .role(Role.ADMIN)
                .build();
    }
}
