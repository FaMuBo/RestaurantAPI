package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.models.dto.MenuDTO;
import com.exampleFinartz.demo.models.request.create.MenuCreateRequest;
import com.exampleFinartz.demo.models.request.update.MenuUpdateRequest;
import org.springframework.stereotype.Service;

@Service
public interface MenuService {

    MenuDTO getMenu(Long id);

    MenuDTO createMenu(MenuCreateRequest menuCreateRequest);

    MenuDTO getBranchMenu(Long branch_id);

    MenuDTO updateMenu(Long id, MenuUpdateRequest menuUpdateRequest);
}
