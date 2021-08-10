package com.exampleFinartz.demo.ServiceTest;


import com.exampleFinartz.demo.models.entity.MealEntity;
import com.exampleFinartz.demo.repositories.MealRepository;
import com.exampleFinartz.demo.services.MealService;
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
public class MealEntityServiceTest {
    private static final String InitStatus = "Pizza";
    private static final String NewStatus = "PizzaTost";
    @InjectMocks
    private MealService mealService;
    @Mock
    private MealRepository mealRepository;

    @Test
    public void ReturnAllMeal() {

        MealEntity county1 = MealEntity.builder().id(1l).name("Pizza").build();
        MealEntity county2 = MealEntity.builder().id(2l).name("PizzaTost").build();

        List<MealEntity> commentList = Arrays.asList(county1, county2);
        Mockito.when(mealRepository.findAll()).thenReturn(commentList);

        List<MealEntity> fetchedList = mealService.getAll();
        assertEquals(commentList.size(), fetchedList.size());
    }

    @Test
    public void ReturnMealById() {
        MealEntity mealEntity = MealEntity.builder().name("Pizza").build();
        Mockito.when(mealRepository.getById(1L)).thenReturn(mealEntity);
        MealEntity fetchedBasket = mealService.getById(1L);
        assertEquals(mealEntity.getId(), fetchedBasket.getId());
    }

    @Test
    public void ReturnSavedMeal() {
        MealEntity mealEntity = MealEntity.builder().name("Pizza").build();
        Mockito.doReturn(mealEntity).when(mealRepository).save(mealEntity);
        MealEntity returnedMealEntity = mealService.create(mealEntity);
        assertEquals(mealEntity.getName(), returnedMealEntity.getName());
    }

    @Test
    public void ReturnUpdatedMeal() {
        MealEntity existMealEntity = MealEntity.builder().id(1L).name(InitStatus).build();
        MealEntity newMealEntity = MealEntity.builder().id(1L).name(NewStatus).build();

        Mockito.when(mealRepository.getById(1L)).thenReturn(existMealEntity);
        Mockito.when(mealRepository.save(newMealEntity)).thenReturn(newMealEntity);

        MealEntity updatedBasket = mealService.update(newMealEntity);

        Assertions.assertEquals(existMealEntity.getName(), NewStatus);
        Assertions.assertNotEquals(existMealEntity.getName(), InitStatus);
    }
}
