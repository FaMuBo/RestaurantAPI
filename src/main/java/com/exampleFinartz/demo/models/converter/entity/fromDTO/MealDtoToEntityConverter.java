package com.exampleFinartz.demo.models.converter.entity.fromDTO;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.ItemDTO;
import com.exampleFinartz.demo.models.dto.MealDTO;
import com.exampleFinartz.demo.models.dto.MenuDTO;
import com.exampleFinartz.demo.models.entity.ItemEntity;
import com.exampleFinartz.demo.models.entity.MealEntity;
import com.exampleFinartz.demo.models.entity.MenuEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MealDtoToEntityConverter implements GenericConverter<MealDTO, MealEntity> {

    private final GenericConverter<MenuDTO, MenuEntity> menuEntityConverter;
    private final GenericConverter<ItemDTO, ItemEntity> itemEntityConverter;

    @Override
    public MealEntity convert(final MealDTO meal) {
        if (meal == null) {
            return null;
        }

        MealEntity mealEntity = new MealEntity();

        mealEntity.setId(meal.getId());
        mealEntity.setName(meal.getName());
        mealEntity.setPrice(meal.getPrice());
        mealEntity.setMenuEntity(convert(meal.getMenu()));

        List<ItemEntity> itemEntities = new ArrayList<>();
        meal.getItemDTOList().forEach(item -> {
            itemEntities.add(convert(item));
        });
        mealEntity.setItemEntities(itemEntities);

        return mealEntity;
    }

    private MenuEntity convert(final MenuDTO menu) {
        return menuEntityConverter.convert(menu);
    }

    private ItemEntity convert(final ItemDTO item) {
        return itemEntityConverter.convert(item);
    }

}