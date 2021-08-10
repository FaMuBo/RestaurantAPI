package com.exampleFinartz.demo.ServiceTest;


import com.exampleFinartz.demo.models.entity.RestaurantsEntity;
import com.exampleFinartz.demo.models.enums.Position;
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
public class RestaurantsEntityServiceTest {

    private static final Position InitStatus = Position.WAITING;
    private static final Position NewStatus = Position.APPROVED;
    @InjectMocks
    private RestaurantsService restaurantsService;
    @Mock
    private RestaurantsRepository restaurantsRepository;

    @Test
    public void ReturnAllRestaurant() {
        RestaurantsEntity restaurantsEntity1 = RestaurantsEntity.builder().id(1l).position(Position.WAITING).build();
        RestaurantsEntity restaurantsEntity2 = RestaurantsEntity.builder().id(2l).position(Position.APPROVED).build();

        List<RestaurantsEntity> commentList = Arrays.asList(restaurantsEntity1, restaurantsEntity2);
        Mockito.when(restaurantsRepository.findAll()).thenReturn(commentList);

        List<RestaurantsEntity> fetchedList = restaurantsService.getAll();
        assertEquals(commentList.size(), fetchedList.size());
    }

    @Test
    public void ReturnRestaurantById() {
        RestaurantsEntity restaurantsEntity = RestaurantsEntity.builder().position(Position.APPROVED).build();
        Mockito.when(restaurantsRepository.getById(1L)).thenReturn(restaurantsEntity);
        RestaurantsEntity fetchedRestaurantsEntity = restaurantsService.getById(1L);
        assertEquals(restaurantsEntity.getId(), fetchedRestaurantsEntity.getId());
    }

    @Test
    public void ReturnSavedRestaurant() {
        RestaurantsEntity restaurantsEntity = RestaurantsEntity.builder().position(Position.APPROVED).build();
        Mockito.doReturn(restaurantsEntity).when(restaurantsRepository).save(restaurantsEntity);
        RestaurantsEntity returnedRestaurantsEntity = restaurantsService.create(restaurantsEntity);
        assertEquals(restaurantsEntity.getPosition(), returnedRestaurantsEntity.getPosition());
    }

    @Test
    public void ReturnUpdatedRestaurant() {
        RestaurantsEntity existRestaurantsEntity = RestaurantsEntity.builder().id(1L).position(InitStatus).build();
        RestaurantsEntity newRestaurantsEntity = RestaurantsEntity.builder().id(1L).position(NewStatus).build();

        Mockito.when(restaurantsRepository.getById(1L)).thenReturn(existRestaurantsEntity);
        Mockito.when(restaurantsRepository.save(newRestaurantsEntity)).thenReturn(newRestaurantsEntity);

        RestaurantsEntity updatedRestaurant = restaurantsService.update(newRestaurantsEntity);
        Assertions.assertEquals(existRestaurantsEntity.getPosition(), NewStatus);
        Assertions.assertNotEquals(existRestaurantsEntity.getPosition(), InitStatus);
    }
}

