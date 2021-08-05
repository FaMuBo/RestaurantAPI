package com.exampleFinartz.demo.converter.dto;

import com.exampleFinartz.demo.converter.GenericConverter;
import com.exampleFinartz.demo.dto.BasketDTO;
import com.exampleFinartz.demo.dto.ItemDTO;
import com.exampleFinartz.demo.dto.MealDTO;
import com.exampleFinartz.demo.dto.MenuDTO;
import com.exampleFinartz.demo.entity.Basket;
import com.exampleFinartz.demo.entity.Item;
import com.exampleFinartz.demo.entity.Meal;
import com.exampleFinartz.demo.entity.Menu;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MealDtoConverter implements GenericConverter<Meal, MealDTO> {

    private final GenericConverter<Menu, MenuDTO> menuDtoConverter;
    private final GenericConverter<Item, ItemDTO> itemDtoConverter;
    private final GenericConverter<Basket, BasketDTO> basketDtoConverter;

    @Override
    public MealDTO convert(final Meal meal) {
        if (meal == null) {
            return null;
        }

        MealDTO meal1 = new MealDTO();

        meal1.setId(meal1.getId());
        meal1.setName(meal1.getName());
        meal1.setPrice(meal1.getPrice());
        meal1.setItems(meal1.getItems());
        meal1.setMenu(convert(meal1.getMenu()));

        return meal1;

    }

    private MenuDTO convert(final Menu menu) {
        return menuDtoConverter.convert(menu);
    }

    private ItemDTO convert(final Item item) {
        return itemDtoConverter.convert(item);
    }

}