package com.exampleFinartz.demo.converter.dto;

import com.exampleFinartz.demo.converter.GenericConverter;
import com.exampleFinartz.demo.dto.BranchDTO;
import com.exampleFinartz.demo.dto.CommentsDTO;
import com.exampleFinartz.demo.dto.MenuDTO;
import com.exampleFinartz.demo.dto.RestaurantsDTO;
import com.exampleFinartz.demo.entity.Branch;
import com.exampleFinartz.demo.entity.Comments;
import com.exampleFinartz.demo.entity.Menu;
import com.exampleFinartz.demo.entity.Restaurants;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BranchDtoConverter implements GenericConverter<Branch, BranchDTO> {

    private final GenericConverter<Menu, MenuDTO> menuDtoConverter;
    private final GenericConverter<Comments, CommentsDTO> commentsDtoConverter;
    private final GenericConverter<Restaurants, RestaurantsDTO> restaurantsDtoConverter;


    @Override
    public BranchDTO convert(final Branch branch) {
        if (branch == null) {
            return null;
        }

        BranchDTO branch1 = new BranchDTO();

        branch1.setId(branch.getId());
        branch1.setMenu(convert(branch1.getMenu()));
        //  branch1.setComments(convert(branch1.getComments()));
        branch1.setName(branch1.getName());
        branch1.setRestaurants(convert(branch1.getRestaurants()));

        return branch1;

    }

    private RestaurantsDTO convert(final Restaurants restaurants) {
        return restaurantsDtoConverter.convert(restaurants);
    }

    private MenuDTO convert(final Menu menu) {
        return menuDtoConverter.convert(menu);
    }

    private CommentsDTO convert(final Comments comments) {
        return commentsDtoConverter.convert(comments);
    }


}
