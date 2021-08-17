package com.exampleFinartz.demo.models.converter.entity.fromCreateRequest;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.MealDTO;
import com.exampleFinartz.demo.models.entity.ItemEntity;
import com.exampleFinartz.demo.models.entity.MealEntity;
import com.exampleFinartz.demo.models.request.create.ItemCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ItemCreateRequestToEntityConverter implements GenericConverter<ItemCreateRequest, ItemEntity> {

    private final GenericConverter<MealDTO, MealEntity> mealEntityConverter;

    @Override
    public ItemEntity convert(final ItemCreateRequest itemCreateRequest) {
        if (itemCreateRequest == null) {
            return null;
        }

        ItemEntity itemEntity = new ItemEntity();

        itemEntity.setName(itemCreateRequest.getName());

        List<MealEntity> mealEntities = new ArrayList<>();
        itemCreateRequest.getMealDTOList().forEach(meal -> {
            mealEntities.add(convert(meal));
        });
        itemEntity.setMealEntities(mealEntities);

        return itemEntity;
    }

    private MealEntity convert(final MealDTO meal) {
        return mealEntityConverter.convert(meal);
    }

}
