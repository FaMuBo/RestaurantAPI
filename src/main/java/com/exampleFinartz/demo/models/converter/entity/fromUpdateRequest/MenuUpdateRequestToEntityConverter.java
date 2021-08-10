package com.exampleFinartz.demo.models.converter.entity.fromUpdateRequest;

import com.exampleFinartz.demo.models.converter.entity.fromDTO.MealDtoToEntityConverter;
import com.exampleFinartz.demo.models.dto.MealDTO;
import com.exampleFinartz.demo.models.entity.MealEntity;
import com.exampleFinartz.demo.models.entity.MenuEntity;
import com.exampleFinartz.demo.models.request.update.MenuUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MenuUpdateRequestToEntityConverter {

    private final MealDtoToEntityConverter mealDtoToEntityConverter;

    public MenuEntity convert(final MenuUpdateRequest menuUpdateRequest,
                              final MenuEntity menuExisted) {
        if (menuUpdateRequest == null)
            return null;

        if (menuUpdateRequest.getMeals() != null) {
            List<MealEntity> mealEntities = new ArrayList<>();
            menuUpdateRequest.getMeals().forEach(meal -> {
                mealEntities.add(convert(meal));
            });
            menuExisted.setMealEntities(mealEntities);
        }

        return menuExisted;
    }

    private MealEntity convert(final MealDTO meal) {
        return mealDtoToEntityConverter.convert(meal);
    }

}