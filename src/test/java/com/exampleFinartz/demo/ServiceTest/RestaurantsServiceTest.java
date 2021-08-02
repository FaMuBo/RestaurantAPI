package com.exampleFinartz.demo.ServiceTest;


import com.exampleFinartz.demo.entities.Restaurants;
import com.exampleFinartz.demo.enums.Position;
import com.exampleFinartz.demo.repositories.RestaurantsRepository;
import com.exampleFinartz.demo.services.RestaurantsService;
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
public class RestaurantsServiceTest {

    private static final Position InitStatus = Position.WAITING;
    private static final Position NewStatus = Position.APPROVED;
    @InjectMocks
    private RestaurantsService restaurantsService;
    @Mock
    private RestaurantsRepository restaurantsRepository;

    @Test
    public void ReturnAllRestaurant() {
        Restaurants restaurants1 = Restaurants.builder().id(1l).position(Position.WAITING).build();
        Restaurants restaurants2 = Restaurants.builder().id(2l).position(Position.APPROVED).build();

        List<Restaurants> commentList = Arrays.asList(restaurants1, restaurants2);
        Mockito.when(restaurantsRepository.findAll()).thenReturn(commentList);

        List<Restaurants> fetchedList = restaurantsService.getAll();
        assertEquals(commentList.size(), fetchedList.size());
    }

    @Test
    public void ReturnRestaurantById() {
        Restaurants restaurants = Restaurants.builder().position(Position.APPROVED).build();
        Mockito.when(restaurantsRepository.getById(1L)).thenReturn(restaurants);
        Restaurants fetchedRestaurants = restaurantsService.getById(1L);
        assertEquals(restaurants.getId(), fetchedRestaurants.getId());
    }

    @Test
    public void ReturnSavedRestaurant() {
        Restaurants restaurants = Restaurants.builder().position(Position.APPROVED).build();
        Mockito.doReturn(restaurants).when(restaurantsRepository).save(restaurants);
        Restaurants returnedRestaurants = restaurantsService.create(restaurants);
        assertEquals(restaurants.getPosition(), returnedRestaurants.getPosition());
    }

    @Test
    public void ReturnUpdatedRestaurant() {
        Restaurants existRestaurants = Restaurants.builder().id(1L).position(InitStatus).build();
        Restaurants newRestaurants = Restaurants.builder().id(1L).position(NewStatus).build();

        Mockito.when(restaurantsRepository.getById(1L)).thenReturn(existRestaurants);
        Mockito.when(restaurantsRepository.save(newRestaurants)).thenReturn(newRestaurants);

        Restaurants updatedRestaurant = restaurantsService.update(newRestaurants);
        Assertions.assertEquals(existRestaurants.getPosition(), NewStatus);
        Assertions.assertNotEquals(existRestaurants.getPosition(), InitStatus);
    }
}

