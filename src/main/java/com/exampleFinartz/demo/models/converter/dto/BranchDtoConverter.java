package com.exampleFinartz.demo.models.converter.dto;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.BranchDTO;
import com.exampleFinartz.demo.models.dto.CommentsDTO;
import com.exampleFinartz.demo.models.dto.MenuDTO;
import com.exampleFinartz.demo.models.dto.RestaurantsDTO;
import com.exampleFinartz.demo.models.entity.BranchEntity;
import com.exampleFinartz.demo.models.entity.CommentsEntity;
import com.exampleFinartz.demo.models.entity.MenuEntity;
import com.exampleFinartz.demo.models.entity.RestaurantsEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class BranchDtoConverter implements GenericConverter<BranchEntity, BranchDTO> {

    private final GenericConverter<MenuEntity, MenuDTO> menuDtoConverter;
    private final GenericConverter<CommentsEntity, CommentsDTO> commentsDtoConverter;
    private final GenericConverter<RestaurantsEntity, RestaurantsDTO> restaurantsDtoConverter;


    @Override
    public BranchDTO convert(final BranchEntity branchEntity) {
        if (branchEntity == null) {
            return null;
        }

        BranchDTO branchDto = new BranchDTO();

        branchDto.setId(branchEntity.getId());
        branchDto.setName(branchEntity.getName());
        branchDto.setPosition(branchEntity.getPosition());
        branchDto.setRestaurants(convert(branchEntity.getRestaurantsEntity()));

        return branchDto;

    }

    private List<CommentsEntity> convert(List<CommentsEntity> comments) {
        return comments;
    }

    private RestaurantsDTO convert(final RestaurantsEntity restaurantsEntity) {
        return restaurantsDtoConverter.convert(restaurantsEntity);
    }

    private MenuDTO convert(final MenuEntity menuEntity) {
        return menuDtoConverter.convert(menuEntity);
    }

    private CommentsDTO convert(final CommentsEntity commentsEntity) {
        return commentsDtoConverter.convert(commentsEntity);
    }


}
