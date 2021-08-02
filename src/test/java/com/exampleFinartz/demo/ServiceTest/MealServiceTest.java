package com.exampleFinartz.demo.ServiceTest;


import com.exampleFinartz.demo.entities.Meal;
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
public class MealServiceTest {
    private static final String InitStatus = "Pizza";
    private static final String NewStatus = "PizzaTost";
    @InjectMocks
    private MealService mealService;
    @Mock
    private MealRepository mealRepository;

    @Test
    public void ReturnAllMeal() {

        Meal county1 = Meal.builder().id(1l).name("Pizza").build();
        Meal county2 = Meal.builder().id(2l).name("PizzaTost").build();

        List<Meal> commentList = Arrays.asList(county1, county2);
        Mockito.when(mealRepository.findAll()).thenReturn(commentList);

        List<Meal> fetchedList = mealService.getAll();
        assertEquals(commentList.size(), fetchedList.size());
    }

    @Test
    public void ReturnMealById() {
        Meal meal = Meal.builder().name("Pizza").build();
        Mockito.when(mealRepository.getById(1L)).thenReturn(meal);
        Meal fetchedBasket = mealService.getById(1L);
        assertEquals(meal.getId(), fetchedBasket.getId());
    }

    @Test
    public void ReturnSavedMeal() {
        Meal meal = Meal.builder().name("Pizza").build();
        Mockito.doReturn(meal).when(mealRepository).save(meal);
        Meal returnedMeal = mealService.create(meal);
        assertEquals(meal.getName(), returnedMeal.getName());
    }

    @Test
    public void ReturnUpdatedMeal() {
        Meal existMeal = Meal.builder().id(1L).name(InitStatus).build();
        Meal newMeal = Meal.builder().id(1L).name(NewStatus).build();

        Mockito.when(mealRepository.getById(1L)).thenReturn(existMeal);
        Mockito.when(mealRepository.save(newMeal)).thenReturn(newMeal);

        Meal updatedBasket = mealService.update(newMeal);

        Assertions.assertEquals(existMeal.getName(), NewStatus);
        Assertions.assertNotEquals(existMeal.getName(), InitStatus);
    }
}
