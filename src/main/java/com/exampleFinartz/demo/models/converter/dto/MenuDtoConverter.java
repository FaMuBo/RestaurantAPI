package com.exampleFinartz.demo.models.converter.dto;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.BranchDTO;
import com.exampleFinartz.demo.models.dto.MealDTO;
import com.exampleFinartz.demo.models.dto.MenuDTO;
import com.exampleFinartz.demo.models.entity.BranchEntity;
import com.exampleFinartz.demo.models.entity.MealEntity;
import com.exampleFinartz.demo.models.entity.MenuEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MenuDtoConverter implements GenericConverter<MenuEntity, MenuDTO> {

    private final GenericConverter<BranchEntity, BranchDTO> branchDtoConverter;
    private final GenericConverter<MealEntity, MealDTO> menulistDtoConverter;


    @Override
    public MenuDTO convert(final MenuEntity menuEntity) {
        if (menuEntity == null) {
            return null;
        }

        MenuDTO menuDto = new MenuDTO();

        menuDto.setId(menuEntity.getId());
        menuDto.setBranch(convert(menuEntity.getBranchEntity()));

//        List<MealDto> meals = new ArrayList<>();
//        menuEntity.getMealEntities().forEach(mealEntity -> {
//            meals.add(convert(mealEntity));
//        });
//        menuDto.setMeals(meals);

        return menuDto;
    }

    private BranchDTO convert(final BranchEntity branchEntity) {
        return branchDtoConverter.convert(branchEntity);
    }

    private MealDTO convert(final MealEntity mealEntity) {
        return menulistDtoConverter.convert(mealEntity);
    }


}