package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.models.dto.MealDTO;
import com.exampleFinartz.demo.models.request.create.MealCreateRequest;
import org.springframework.stereotype.Service;

@Service
public interface MealService {


    MealDTO getMeal(Long id);

    MealDTO createMeal(MealCreateRequest mealCreateRequest);

}
