package com.exampleFinartz.demo.models.converter.entity.fromCreateRequest;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.ItemDTO;
import com.exampleFinartz.demo.models.dto.MenuDTO;
import com.exampleFinartz.demo.models.entity.ItemEntity;
import com.exampleFinartz.demo.models.entity.MealEntity;
import com.exampleFinartz.demo.models.entity.MenuEntity;
import com.exampleFinartz.demo.models.request.create.MealCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MealCreateRequestToEntityConverter implements GenericConverter<MealCreateRequest, MealEntity> {

    private final GenericConverter<MenuDTO, MenuEntity> menuEntityConverter;
    private final GenericConverter<ItemDTO, ItemEntity> itemEntityConverter;

    @Override
    public MealEntity convert(final MealCreateRequest mealCreateRequest) {
        if (mealCreateRequest == null) {
            return null;
        }

        MealEntity mealEntity = new MealEntity();

        mealEntity.setName(mealCreateRequest.getName());
        mealEntity.setPrice(mealCreateRequest.getPrice());
        mealEntity.setMenuEntity(convert(mealCreateRequest.getMenu()));

        List<ItemEntity> itemEntities = new ArrayList<>();
        mealCreateRequest.getItemDTOList().forEach(item -> {
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
