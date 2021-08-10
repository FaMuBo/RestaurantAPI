package com.exampleFinartz.demo.models.converter.entity.fromUpdateRequest;

import com.exampleFinartz.demo.models.converter.entity.fromDTO.MenuDtoToEntityConverter;
import com.exampleFinartz.demo.models.dto.MenuDTO;
import com.exampleFinartz.demo.models.entity.BranchEntity;
import com.exampleFinartz.demo.models.entity.MenuEntity;
import com.exampleFinartz.demo.models.request.update.BranchUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BranchUpdateRequestToEntityConverter {

    private final MenuDtoToEntityConverter menuDtoToEntityConverter;

    public BranchEntity convert(final BranchUpdateRequest branchUpdateRequest,
                                final BranchEntity branchExisted) {

        if (branchUpdateRequest == null)
            return null;

        if (branchUpdateRequest.getPosition() != null)
            branchExisted.setPosition(branchUpdateRequest.getPosition());

        if (branchUpdateRequest.getMenu() != null)
            branchExisted.setMenuEntity(convert(branchUpdateRequest.getMenu()));

        return branchExisted;
    }

    private MenuEntity convert(final MenuDTO menu) {
        return menuDtoToEntityConverter.convert(menu);
    }
}
