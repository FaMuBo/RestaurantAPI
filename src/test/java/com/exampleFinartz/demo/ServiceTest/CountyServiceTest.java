package com.exampleFinartz.demo.ServiceTest;


import com.exampleFinartz.demo.entities.County;
import com.exampleFinartz.demo.repositories.CountyRepository;
import com.exampleFinartz.demo.services.CountyService;
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
public class CountyServiceTest {

    private static final String COUNTY_UMRANİYE = "Ümraniye";
    private static final String COUNTY_KARTAL = "Kartal";


    @InjectMocks
    private CountyService countyService;

    @Mock
    private CountyRepository countyRepository;


    @Test
    public void ReturnAllCounty() {
        County county1 = County.builder().id(1l).name("Ümraniye").build();
        County county2 = County.builder().id(2l).name("Avcılar").build();
        List<County> countyList = Arrays.asList(county1, county2);

        Mockito.when(countyRepository.findAll()).thenReturn(countyList);

        List<County> fetchedList = countyService.getAll();

        assertEquals(countyList.size(), fetchedList.size());
    }

    @Test
    public void ReturnCountyById() {
        County county = County.builder().name("Ümraniye").build();

        Mockito.when(countyRepository.getById(1L)).thenReturn(county);

        County fetchedCounty = countyService.getById(1L);

        assertEquals(county.getId(), fetchedCounty.getId());
    }

    @Test
    public void ReturnSavedCounty() {
        County county = County.builder().name("Ümraniye").build();

        Mockito.doReturn(county).when(countyRepository).save(county);

        County returnedCounty = countyService.create(county);

        assertEquals(county.getName(), returnedCounty.getName());
    }

    @Test
    public void ReturnUpdatedCounty() {
        County existCounty = County.builder().id(1L).name(COUNTY_UMRANİYE).build();
        County newCounty = County.builder().id(1l).name(COUNTY_KARTAL).build();

        Mockito.when(countyRepository.getById(1L)).thenReturn(existCounty);
        Mockito.when(countyRepository.save(newCounty)).thenReturn(newCounty);


        County updatedCounty = countyService.update(newCounty);

        Assertions.assertNotEquals(existCounty.getName(), COUNTY_KARTAL);
        Assertions.assertEquals(existCounty.getName(), COUNTY_UMRANİYE);

    }

}
