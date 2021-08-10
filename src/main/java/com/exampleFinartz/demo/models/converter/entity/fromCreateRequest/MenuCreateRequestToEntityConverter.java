package com.exampleFinartz.demo.models.converter.entity.fromCreateRequest;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.BranchDTO;
import com.exampleFinartz.demo.models.dto.MealDTO;
import com.exampleFinartz.demo.models.entity.BranchEntity;
import com.exampleFinartz.demo.models.entity.MealEntity;
import com.exampleFinartz.demo.models.entity.MenuEntity;
import com.exampleFinartz.demo.models.request.create.MenuCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MenuCreateRequestToEntityConverter implements GenericConverter<MenuCreateRequest, MenuEntity> {

    private final GenericConverter<BranchDTO, BranchEntity> branchEntityConverter;
    private final GenericConverter<MealDTO, MealEntity> mealEntityConverter;

    @Override
    public MenuEntity convert(final MenuCreateRequest menuCreateRequest) {
        if (menuCreateRequest == null) {
            return null;
        }

        MenuEntity menuEntity = new MenuEntity();

        menuEntity.setBranchEntity(convert(menuCreateRequest.getBranch()));

        List<MealEntity> mealEntities = new ArrayList<>();
        menuCreateRequest.getMealDTOList().forEach(meal -> {
            mealEntities.add(convert(meal));
        });
        menuEntity.setMealEntities(mealEntities);

        return menuEntity;
    }

    private BranchEntity convert(BranchDTO branch) {
        return branchEntityConverter.convert(branch);
    }

    private MealEntity convert(MealDTO meal) {
        return mealEntityConverter.convert(meal);
    }

}