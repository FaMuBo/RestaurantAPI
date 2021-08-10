package com.exampleFinartz.demo.models.converter.dto;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.ItemDTO;
import com.exampleFinartz.demo.models.dto.MealDTO;
import com.exampleFinartz.demo.models.entity.ItemEntity;
import com.exampleFinartz.demo.models.entity.MealEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ItemDtoConverter implements GenericConverter<ItemEntity, ItemDTO> {

    private final GenericConverter<MealEntity, MealDTO> mealDtoConverter;

    @Override
    public ItemDTO convert(final ItemEntity itemEntity) {
        if (itemEntity == null) {
            return null;
        }

        ItemDTO itemDto = new ItemDTO();

        itemDto.setId(itemEntity.getId());
        itemDto.setName(itemEntity.getName());
        itemDto.setUnitType(itemEntity.getUnitType());
        // items1.setMealList(convert(items1.getMealList()));

        return itemDto;

    }

    private MealDTO convert(final MealEntity mealEntity) {
        return mealDtoConverter.convert(mealEntity);
    }

}