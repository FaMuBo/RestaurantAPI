package com.exampleFinartz.demo.ControllerTest;

import com.exampleFinartz.demo.controllers.UserController;
import com.exampleFinartz.demo.entity.User;
import com.exampleFinartz.demo.enums.Role;
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
public class UserControllerTest {
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
        User user = this.generateUser();
        String URI = "/users";
        String inputJson = this.mapToJson(user);
        Mockito.when(userService.update(Mockito.any(User.class))).thenReturn(user);
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
        List<User> userList = new ArrayList<>();
        userList.add(this.generateUser());
        String URI = "/users";
        String inputInJson = this.mapToJson(userList);
        Mockito.when(userService.getAll()).thenReturn(userList);
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
        User user = this.generateUser();
        String URI = "/users/1";
        String inputJson = this.mapToJson(user);
        Mockito.when(userService.getById(Mockito.anyLong())).thenReturn(user);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String outputJsonValue = result.getResponse().getContentAsString();
        Assertions.assertThat("").isEqualTo(outputJsonValue);
    }

    @Test
    public void getUserByName() throws Exception {
        User user = this.generateUser();
        String URI = "/users/name/test";
        String inputJson = this.mapToJson(user);
        Mockito.when(userService.getUserByName(Mockito.anyString())).thenReturn(user);
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
        User user = this.generateUser();
        String URI = "/users";
        String inputJson = this.mapToJson(user);
        Mockito.when(userService.update(Mockito.any(User.class))).thenReturn(user);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put(URI)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON).content(this.mapToJson(user));
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String outputJsonValue = response.getContentAsString();
        Assertions.assertThat("").isEqualTo(outputJsonValue);
    }

    @Test
    public void deleteUser() throws Exception {
        User user = this.generateUser();
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

    private User generateUser() {
        return User.builder()
                .name("testname")
                .email("test@mail.com")
                .role(Role.ADMIN)
                .build();
    }
}
