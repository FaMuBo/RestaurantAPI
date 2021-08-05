package com.exampleFinartz.demo.converter.dto;

import com.exampleFinartz.demo.converter.GenericConverter;
import com.exampleFinartz.demo.dto.ItemDTO;
import com.exampleFinartz.demo.dto.MealDTO;
import com.exampleFinartz.demo.entity.Item;
import com.exampleFinartz.demo.entity.Meal;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ItemDtoConverter implements GenericConverter<Item, ItemDTO> {

    private final GenericConverter<Meal, MealDTO> mealDtoConverter;

    @Override
    public ItemDTO convert(final Item item) {
        if (item == null) {
            return null;
        }

        ItemDTO items1 = new ItemDTO();

        items1.setId(items1.getId());
        items1.setName(items1.getName());
        // items1.setMealList(convert(items1.getMealList()));

        return items1;

    }

    private MealDTO convert(final Meal meal) {
        return mealDtoConverter.convert(meal);
    }

}