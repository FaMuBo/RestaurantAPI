package com.exampleFinartz.demo.ServiceTest;

import com.exampleFinartz.demo.entities.Address;
import com.exampleFinartz.demo.repositories.AddressRepository;
import com.exampleFinartz.demo.services.AddressService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class AddressServiceTest {

    private static final String DISTRICT_MODA = "Moda";
    private static final String DISTRICT_CAFERAGA = "Caferaga";
    private static final String OTHER_CONTENT_HOME = "Home";
    private static final String OTHER_CONTENT_CAMPUS = "Campus";

    @InjectMocks
    private AddressService addressService;

    @Mock
    private AddressRepository addressRepository;

    @Test
    public void ReturnAllAddress() {
        Address address1 = Address.builder().id(1L).build();
        Address address2 = Address.builder().id(2L).build();
        List<Address> addressList = Arrays.asList(address1, address2);
        Mockito.when(addressRepository.findAll()).thenReturn(addressList);
        List<Address> fetchedList = addressService.getAll();
        assertEquals(addressList.size(), fetchedList.size());
    }

    @Test
    public void ReturnAddressById() {
        Address address = Address.builder().district("Gümüşpınar Mahallesi").build();
        Mockito.when(addressRepository.getById(1L)).thenReturn(address);
        Address fetchedAddress = addressService.getById(1L);
        assertEquals(address.getId(), fetchedAddress.getId());
    }

    @Test
    public void ReturnSavedAddress() {
        Address address = Address.builder().build();
        Mockito.doReturn(address).when(addressRepository).save(address);
        Address returnedAddress = addressService.create(address);
    }

    @Test
    public void ReturnUpdatedAddress() {
        Address existAddress = Address.builder().id(1l).other_content(OTHER_CONTENT_HOME).district(DISTRICT_CAFERAGA).build();
        Address newAddress = Address.builder().id(1L).other_content(OTHER_CONTENT_CAMPUS).district(DISTRICT_MODA).build();

        Mockito.when(addressRepository.getById(1L)).thenReturn(existAddress);
        Mockito.when(addressRepository.save(newAddress)).thenReturn(newAddress);

        Address updatedAddress = addressService.update(newAddress);
        Assertions.assertNotEquals(existAddress.getDistrict(), DISTRICT_CAFERAGA);
        Assertions.assertEquals(existAddress.getDistrict(), DISTRICT_MODA);
    }
}
