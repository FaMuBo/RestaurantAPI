package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.models.converter.dto.MenuDtoConverter;
import com.exampleFinartz.demo.models.converter.entity.fromCreateRequest.MenuCreateRequestToEntityConverter;
import com.exampleFinartz.demo.models.converter.entity.fromUpdateRequest.MenuUpdateRequestToEntityConverter;
import com.exampleFinartz.demo.models.dto.MenuDTO;
import com.exampleFinartz.demo.models.entity.MenuEntity;
import com.exampleFinartz.demo.models.request.create.MenuCreateRequest;
import com.exampleFinartz.demo.models.request.update.MenuUpdateRequest;
import com.exampleFinartz.demo.repositories.MenuRepository;
import com.exampleFinartz.demo.services.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final MenuDtoConverter menuDtoConverter;
    private final MenuCreateRequestToEntityConverter menuCreateRequestToEntityConverter;
    private final MenuUpdateRequestToEntityConverter menuUpdateRequestToEntityConverter;


    @Override
    public MenuDTO getMenu(Long id) {
        return menuDtoConverter.convert(menuRepository.getById(id));
    }

    @Override
    public MenuDTO createMenu(MenuCreateRequest menuCreateRequest) {
        MenuEntity menuEntity = menuCreateRequestToEntityConverter.convert(menuCreateRequest);
        return menuDtoConverter.convert(menuRepository.save(menuEntity));
    }

    @Override
    public MenuDTO updateMenu(Long id, MenuUpdateRequest menuUpdateRequest) {
        MenuEntity menuExisted = menuRepository.getById(id);

        MenuEntity menuUpdated =
                menuUpdateRequestToEntityConverter.convert(menuUpdateRequest, menuExisted);

        return menuDtoConverter.convert(menuRepository.save(menuUpdated));
    }

}