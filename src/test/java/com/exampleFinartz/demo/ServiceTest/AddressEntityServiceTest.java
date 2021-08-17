//package com.exampleFinartz.demo.ServiceTest;
//
//import com.exampleFinartz.demo.models.entity.AddressEntity;
//import com.exampleFinartz.demo.repositories.AddressRepository;
//import com.exampleFinartz.demo.services.AddressService;
//import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@RunWith(MockitoJUnitRunner.class)
//
//public class AddressEntityServiceTest {
//
//    private static final String DISTRICT_MODA = "Moda";
//    private static final String DISTRICT_CAFERAGA = "Caferaga";
//    private static final String OTHER_CONTENT_HOME = "Home";
//    private static final String OTHER_CONTENT_CAMPUS = "Campus";
//
//    @InjectMocks
//    private AddressService addressService;
//
//    @Mock
//    private AddressRepository addressRepository;
//
//    @Test
//    public void ReturnAllAddress() {
//        AddressEntity addressEntity1 = AddressEntity.builder().id(1L).build();
//        AddressEntity addressEntity2 = AddressEntity.builder().id(2L).build();
//        List<AddressEntity> addressEntityList = Arrays.asList(addressEntity1, addressEntity2);
//        Mockito.when(addressRepository.findAll()).thenReturn(addressEntityList);
//        List<AddressEntity> fetchedList = addressService.getAll();
//        assertEquals(addressEntityList.size(), fetchedList.size());
//    }
//
//    @Test
//    public void ReturnAddressById() {
//        AddressEntity addressEntity = AddressEntity.builder().district("Gümüşpınar Mahallesi").build();
//        Mockito.when(addressRepository.getById(1L)).thenReturn(addressEntity);
//        AddressEntity fetchedAddressEntity = addressService.getById(1L);
//        assertEquals(addressEntity.getId(), fetchedAddressEntity.getId());
//    }
//
//    @Test
//    public void ReturnSavedAddress() {
//        AddressEntity addressEntity = AddressEntity.builder().build();
//        Mockito.doReturn(addressEntity).when(addressRepository).save(addressEntity);
//        AddressEntity returnedAddressEntity = addressService.create(addressEntity);
//    }
//
//    @Test
//    public void ReturnUpdatedAddress() {
//        AddressEntity existAddressEntity = AddressEntity.builder().id(1l).other_content(OTHER_CONTENT_HOME).district(DISTRICT_CAFERAGA).build();
//        AddressEntity newAddressEntity = AddressEntity.builder().id(1L).other_content(OTHER_CONTENT_CAMPUS).district(DISTRICT_MODA).build();
//
//        Mockito.when(addressRepository.getById(1L)).thenReturn(existAddressEntity);
//        Mockito.when(addressRepository.save(newAddressEntity)).thenReturn(newAddressEntity);
//
//        AddressEntity updatedAddressEntity = addressService.update(newAddressEntity);
//        Assertions.assertNotEquals(existAddressEntity.getDistrict(), DISTRICT_CAFERAGA);
//        Assertions.assertEquals(existAddressEntity.getDistrict(), DISTRICT_MODA);
//    }
//}
