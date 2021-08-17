//package com.exampleFinartz.demo.ControllerTest;
//
//
//import com.exampleFinartz.demo.controllers.AddressController;
//import com.exampleFinartz.demo.models.dto.AddressDTO;
//import com.exampleFinartz.demo.services.AddressService;
//import com.fasterxml.jackson.databind.ObjectWriter;
//import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)
//@WebMvcTest(AddressController.class)
//public class AddressEntityControllerTest {
//
//    private  static final String URL_ADDRESS="/address";
//    private  static final String DISTRICT_ADDRESS="Gumuspınar";
//    private  static final String NAME_EV="Ev";
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private AddressService addressService;
//
//    @MockBean
//    private UserDetailService userDetailService;
//    private ObjectWriter objectWriter;
//
//    @Test
//    public void GetByAddressId_thenReturnAddress() throws Exception{
//
//        AddressDTO address=AddressDTO.builder().name(NAME_EV).district(DISTRICT_ADDRESS).id(1L).build();
//
//        Mockito.when(addressService.getAddress(1L).thenReturn(address));
//
//        mockMvc.perform(get(URL_ADDRESS+"/1"))
//                .contentType(MediaType.APPLICATION_JSON)
//                .andExpect(status().isOk))
//                .andExpect(jsonPath("name", Matcher.is(NAME_EV)));
//    }
//
//
//
//
//
//
//
//
//
//}