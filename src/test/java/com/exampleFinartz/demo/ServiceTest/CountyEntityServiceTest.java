//package com.exampleFinartz.demo.ServiceTest;
//
//
//import com.exampleFinartz.demo.models.entity.CountyEntity;
//import com.exampleFinartz.demo.repositories.CountyRepository;
//import com.exampleFinartz.demo.services.CountyService;
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
//public class CountyEntityServiceTest {
//
//    private static final String COUNTY_UMRANİYE = "Ümraniye";
//    private static final String COUNTY_KARTAL = "Kartal";
//
//
//    @InjectMocks
//    private CountyService countyService;
//
//    @Mock
//    private CountyRepository countyRepository;
//
//
//    @Test
//    public void ReturnAllCounty() {
//        CountyEntity countyEntity1 = CountyEntity.builder().id(1l).name("Ümraniye").build();
//        CountyEntity countyEntity2 = CountyEntity.builder().id(2l).name("Avcılar").build();
//        List<CountyEntity> countyEntityList = Arrays.asList(countyEntity1, countyEntity2);
//
//        Mockito.when(countyRepository.findAll()).thenReturn(countyEntityList);
//
//        List<CountyEntity> fetchedList = countyService.getAll();
//
//        assertEquals(countyEntityList.size(), fetchedList.size());
//    }
//
//    @Test
//    public void ReturnCountyById() {
//        CountyEntity countyEntity = CountyEntity.builder().name("Ümraniye").build();
//
//        Mockito.when(countyRepository.getById(1L)).thenReturn(countyEntity);
//
//        CountyEntity fetchedCountyEntity = countyService.getById(1L);
//
//        assertEquals(countyEntity.getId(), fetchedCountyEntity.getId());
//    }
//
//    @Test
//    public void ReturnSavedCounty() {
//        CountyEntity countyEntity = CountyEntity.builder().name("Ümraniye").build();
//
//        Mockito.doReturn(countyEntity).when(countyRepository).save(countyEntity);
//
//        CountyEntity returnedCountyEntity = countyService.create(countyEntity);
//
//        assertEquals(countyEntity.getName(), returnedCountyEntity.getName());
//    }
//
//    @Test
//    public void ReturnUpdatedCounty() {
//        CountyEntity existCountyEntity = CountyEntity.builder().id(1L).name(COUNTY_UMRANİYE).build();
//        CountyEntity newCountyEntity = CountyEntity.builder().id(1l).name(COUNTY_KARTAL).build();
//
//        Mockito.when(countyRepository.getById(1L)).thenReturn(existCountyEntity);
//        Mockito.when(countyRepository.save(newCountyEntity)).thenReturn(newCountyEntity);
//
//
//        CountyEntity updatedCountyEntity = countyService.update(newCountyEntity);
//
//        Assertions.assertNotEquals(existCountyEntity.getName(), COUNTY_KARTAL);
//        Assertions.assertEquals(existCountyEntity.getName(), COUNTY_UMRANİYE);
//    }
//}
