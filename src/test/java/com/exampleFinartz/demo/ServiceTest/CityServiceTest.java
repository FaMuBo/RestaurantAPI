package com.exampleFinartz.demo.ServiceTest;

import com.exampleFinartz.demo.entity.City;
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
public class CityServiceTest {

    private static final String NAME_ISTANBUL = "Istanbul";
    private static final String NAME_ANKARA = "Ankara";


    @InjectMocks
    private CityService cityService;

    @Mock
    private CityRepository cityRepository;


    @Test
    public void ReturnAllCity() {
        City city1 = City.builder().id(1l).name("İstanbul").build();
        City city2 = City.builder().id(2l).name("Kral Burger Avcılar").build();
        List<City> cityList = Arrays.asList(city1, city2);

        Mockito.when(cityRepository.findAll()).thenReturn(cityList);

        List<City> fetchedList = cityService.getAll();

        assertEquals(cityList.size(), fetchedList.size());
    }

    @Test
    public void ReturnCityById() {
        City city = City.builder().name("İstanbul").build();

        Mockito.when(cityRepository.getById(1L)).thenReturn(city);

        City fetchedCity = cityService.getById(1L);

        assertEquals(city.getId(), fetchedCity.getId());
    }

    @Test
    public void ReturnSavedCity() {
        City city = City.builder().name("İstanbul").build();

        Mockito.doReturn(city).when(cityRepository).save(city);

        City returnedCity = cityService.create(city);

        assertEquals(city.getName(), returnedCity.getName());
    }

    @Test
    public void ReturnUpdatedCity() {
        City existCity = City.builder().id(1L).name(NAME_ISTANBUL).build();
        City newCity = City.builder().id(1L).name(NAME_ANKARA).build();

        Mockito.when(cityRepository.getById(1L)).thenReturn(existCity);
        Mockito.when(cityRepository.save(newCity)).thenReturn(newCity);


        City updatedCity = cityService.update(newCity);
        Assertions.assertNotEquals(existCity.getName(), NAME_ISTANBUL);
        Assertions.assertEquals(existCity.getName(), NAME_ANKARA);

    }

}
