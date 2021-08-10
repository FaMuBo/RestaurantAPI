package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.models.converter.dto.MealDtoConverter;
import com.exampleFinartz.demo.models.converter.entity.fromCreateRequest.MealCreateRequestToEntityConverter;
import com.exampleFinartz.demo.models.dto.MealDTO;
import com.exampleFinartz.demo.models.entity.MealEntity;
import com.exampleFinartz.demo.models.request.create.MealCreateRequest;
import com.exampleFinartz.demo.repositories.MealRepository;
import com.exampleFinartz.demo.services.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;
    private final MealDtoConverter mealDtoConverter;
    private final MealCreateRequestToEntityConverter mealCreateRequestToEntityConverter;

    @Override
    public MealDTO getMeal(Long id) {
        return mealDtoConverter.convert(mealRepository.getById(id));
    }

    @Override
    public MealDTO createMeal(MealCreateRequest mealCreateRequest) {
        MealEntity mealEntity = mealCreateRequestToEntityConverter.convert(mealCreateRequest);
        return mealDtoConverter.convert(mealRepository.save(mealEntity));
    }

}