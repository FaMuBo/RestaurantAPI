package com.exampleFinartz.demo.ServiceTest;

import com.exampleFinartz.demo.models.entity.CityEntity;
import com.exampleFinartz.demo.repositories.CityRepository;
import com.exampleFinartz.demo.services.CityService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CityEntityServiceTest {

    private static final String NAME_ISTANBUL = "Istanbul";
    private static final String NAME_ANKARA = "Ankara";


    @InjectMocks
    private CityService cityService;

    @Mock
    private CityRepository cityRepository;


    @Test
    public void ReturnAllCity() {
        CityEntity cityEntity1 = CityEntity.builder().id(1l).name("İstanbul").build();
        CityEntity cityEntity2 = CityEntity.builder().id(2l).name("Kral Burger Avcılar").build();
        List<CityEntity> cityEntityList = Arrays.asList(cityEntity1, cityEntity2);

        Mockito.when(cityRepository.findAll()).thenReturn(cityEntityList);

        List<CityEntity> fetchedList = cityService.getAll();

        assertEquals(cityEntityList.size(), fetchedList.size());
    }

    @Test
    public void ReturnCityById() {
        CityEntity cityEntity = CityEntity.builder().name("İstanbul").build();

        Mockito.when(cityRepository.getById(1L)).thenReturn(cityEntity);

        CityEntity fetchedCityEntity = cityService.getById(1L);

        assertEquals(cityEntity.getId(), fetchedCityEntity.getId());
    }

    @Test
    public void ReturnSavedCity() {
        CityEntity cityEntity = CityEntity.builder().name("İstanbul").build();

        Mockito.doReturn(cityEntity).when(cityRepository).save(cityEntity);

        CityEntity returnedCityEntity = cityService.create(cityEntity);

        assertEquals(cityEntity.getName(), returnedCityEntity.getName());
    }

    @Test
    public void ReturnUpdatedCity() {
        CityEntity existCityEntity = CityEntity.builder().id(1L).name(NAME_ISTANBUL).build();
        CityEntity newCityEntity = CityEntity.builder().id(1L).name(NAME_ANKARA).build();

        Mockito.when(cityRepository.getById(1L)).thenReturn(existCityEntity);
        Mockito.when(cityRepository.save(newCityEntity)).thenReturn(newCityEntity);


        CityEntity updatedCityEntity = cityService.update(newCityEntity);
        Assertions.assertNotEquals(existCityEntity.getName(), NAME_ISTANBUL);
        Assertions.assertEquals(existCityEntity.getName(), NAME_ANKARA);

    }

}
