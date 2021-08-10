package com.exampleFinartz.demo.models.converter.entity.fromDTO;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.ItemDTO;
import com.exampleFinartz.demo.models.entity.ItemEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemDtoToEntityConverter implements GenericConverter<ItemDTO, ItemEntity> {

    @Override
    public ItemEntity convert(final ItemDTO item) {
        if (item == null) {
            return null;
        }

        ItemEntity itemEntity = new ItemEntity();

        itemEntity.setId(item.getId());
        itemEntity.setName(item.getName());
        itemEntity.setUnitType(item.getUnitType());

        return itemEntity;
    }


}