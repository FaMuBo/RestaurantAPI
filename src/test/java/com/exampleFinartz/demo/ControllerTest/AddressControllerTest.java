package com.exampleFinartz.demo.ControllerTest;

import com.exampleFinartz.demo.controllers.AddressController;
import com.exampleFinartz.demo.entity.Address;
import com.exampleFinartz.demo.entity.City;
import com.exampleFinartz.demo.entity.County;
import com.exampleFinartz.demo.entity.User;
import com.exampleFinartz.demo.repositories.AddressRepository;
import com.exampleFinartz.demo.services.AddressService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = AddressController.class)
public class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressService addressService;

    @MockBean
    private AddressRepository addressRepository;


    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    @Test
    public void getAll() throws Exception {

        List<Address> addressList = new ArrayList<>();
        addressList.add(this.generateAddress());

        Mockito.when(addressService.getAll()).thenReturn(addressList);

        String URI = "/address";
        String inputJson = this.mapToJson(addressList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertThat(inputJson).isEqualTo(outputJson);

    }

    @Test
    public void getAddress() throws Exception {

        Address address = this.generateAddress();

        Mockito.when(addressService.getById(Mockito.anyLong())).thenReturn(address);

        String URI = "/address/2";
        String inputJson = this.mapToJson(address);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertThat(inputJson).isEqualTo(outputJson);
    }

    @Test
    public void addAddress() throws Exception {

        Address address = this.generateAddress();

        String URI = "/address";
        String inputJson = this.mapToJson(address);

        Mockito.when(addressService.create(Mockito.any(Address.class))).thenReturn(address);

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
    public void updateAddress() throws Exception {

        Address address = this.generateAddress();

        String URI = "/address";
        String inputJson = this.mapToJson(address);

        Mockito.when(addressService.update(Mockito.any(Address.class))).thenReturn(address);

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
    public void deleteAddress() throws Exception {

        Address address = this.generateAddress();

        String URI = "/address/2";
//bak buraya ( 150 thenReturn() - 161 actual "")
        Mockito.when(addressService.delete(Mockito.anyLong())).thenReturn("success");

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete(URI)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertThat("").isEqualTo(outputJson);
    }

    private Address generateAddress() {

        return Address.builder()
                .city(City.builder().name("İstanbul").build())
                .county(County.builder().name("Pendik").build())
                .other_content("Güzelyalı mah.")
                .user(User.builder().name("test").build())
                .build();
    }
}