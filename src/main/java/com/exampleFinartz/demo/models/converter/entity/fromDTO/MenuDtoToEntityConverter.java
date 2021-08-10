package com.exampleFinartz.demo.models.converter.entity.fromDTO;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.BranchDTO;
import com.exampleFinartz.demo.models.dto.MenuDTO;
import com.exampleFinartz.demo.models.entity.BranchEntity;
import com.exampleFinartz.demo.models.entity.MenuEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MenuDtoToEntityConverter implements GenericConverter<MenuDTO, MenuEntity> {

    private final GenericConverter<BranchDTO, BranchEntity> branchEntityConverter;
//    private final GenericConverter<MealDto, MealEntity> mealEntityConverter;

    @Override
    public MenuEntity convert(final MenuDTO menu) {
        if (menu == null) {
            return null;
        }

        MenuEntity menuEntity = new MenuEntity();

        menuEntity.setId(menu.getId());
        menuEntity.setBranchEntity(convert(menu.getBranch()));


        return menuEntity;
    }

    private BranchEntity convert(BranchDTO branch) {
        return branchEntityConverter.convert(branch);
    }

}