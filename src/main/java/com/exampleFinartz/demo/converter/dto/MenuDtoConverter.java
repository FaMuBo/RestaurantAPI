package com.exampleFinartz.demo.converter.dto;

import com.exampleFinartz.demo.converter.GenericConverter;
import com.exampleFinartz.demo.dto.BranchDTO;
import com.exampleFinartz.demo.dto.MealDTO;
import com.exampleFinartz.demo.dto.MenuDTO;
import com.exampleFinartz.demo.entity.Branch;
import com.exampleFinartz.demo.entity.Meal;
import com.exampleFinartz.demo.entity.Menu;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MenuDtoConverter implements GenericConverter<Menu, MenuDTO> {

    private final GenericConverter<Branch, BranchDTO> branchDtoConverter;
    private final GenericConverter<Meal, MealDTO> menulistDtoConverter;


    @Override
    public MenuDTO convert(final Menu menu) {
        if (menu == null) {
            return null;
        }

        MenuDTO menu1 = new MenuDTO();

        menu1.setId(menu1.getId());
        menu1.setItem_count(menu1.getItem_count());
        menu1.setMeal(menu1.getMeal());
        menu1.setBranch(convert(menu1.getBranch()));
        // menu1.setMeallistt(convert(menu1.getMeallistt()));


        return menu1;

    }

    private BranchDTO convert(final Branch branch) {
        return branchDtoConverter.convert(branch);
    }

    private MealDTO convert(final Meal meal) {
        return menulistDtoConverter.convert(meal);
    }


}