package com.exampleFinartz.demo.models.converter.dto;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.BasketDTO;
import com.exampleFinartz.demo.models.dto.ItemDTO;
import com.exampleFinartz.demo.models.dto.MealDTO;
import com.exampleFinartz.demo.models.dto.MenuDTO;
import com.exampleFinartz.demo.models.entity.BasketEntity;
import com.exampleFinartz.demo.models.entity.ItemEntity;
import com.exampleFinartz.demo.models.entity.MealEntity;
import com.exampleFinartz.demo.models.entity.MenuEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class MealDtoConverter implements GenericConverter<MealEntity, MealDTO> {

    private final GenericConverter<MenuEntity, MenuDTO> menuDtoConverter;
    private final GenericConverter<ItemEntity, ItemDTO> itemDtoConverter;
    private final GenericConverter<BasketEntity, BasketDTO> basketDtoConverter;

    @Override
    public MealDTO convert(final MealEntity mealEntity) {
        if (mealEntity == null) {
            return null;
        }

        MealDTO mealDto = new MealDTO();

        mealDto.setId(mealEntity.getId());
        mealDto.setName(mealEntity.getName());
        mealDto.setPrice(mealEntity.getPrice());
        mealDto.setMenu(convert(mealEntity.getMenuEntity()));

        List<ItemDTO> items = new ArrayList<>();
        mealEntity.getItemEntities().forEach(itemEntity -> {
            items.add(convert(itemEntity));
        });
        mealDto.setItemDTOList(items);

        return mealDto;
    }


    private MenuDTO convert(final MenuEntity menuEntity) {
        return menuDtoConverter.convert(menuEntity);
    }

    private ItemDTO convert(final ItemEntity itemEntity) {
        return itemDtoConverter.convert(itemEntity);
    }

}