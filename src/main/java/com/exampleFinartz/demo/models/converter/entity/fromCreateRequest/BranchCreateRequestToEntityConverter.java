package com.exampleFinartz.demo.models.converter.entity.fromCreateRequest;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.AddressDTO;
import com.exampleFinartz.demo.models.dto.MenuDTO;
import com.exampleFinartz.demo.models.dto.RestaurantsDTO;
import com.exampleFinartz.demo.models.entity.AddressEntity;
import com.exampleFinartz.demo.models.entity.BranchEntity;
import com.exampleFinartz.demo.models.entity.MenuEntity;
import com.exampleFinartz.demo.models.entity.RestaurantsEntity;
import com.exampleFinartz.demo.models.request.create.BranchCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BranchCreateRequestToEntityConverter implements GenericConverter<BranchCreateRequest, BranchEntity> {

    private final GenericConverter<MenuDTO, MenuEntity> menuEntityConverter;
    private final GenericConverter<RestaurantsDTO, RestaurantsEntity> restaurantEntityConverter;
    private final GenericConverter<AddressDTO, AddressEntity> addressEntityConverter;

    @Override
    public BranchEntity convert(final BranchCreateRequest branchCreateRequest) {
        if (branchCreateRequest == null) {
            return null;
        }

        BranchEntity branchEntity = new BranchEntity();

        branchEntity.setName(branchCreateRequest.getName());
        branchEntity.setPosition(branchCreateRequest.getPosition());
        branchEntity.setMenuEntity(convert(branchCreateRequest.getMenu()));
        branchEntity.setRestaurantsEntity(convert(branchCreateRequest.getRestaurants()));
        branchEntity.setAddressEntity(convert(branchCreateRequest.getAddress()));


        return branchEntity;
    }

    private AddressEntity convert(final AddressDTO address) {
        return addressEntityConverter.convert(address);
    }

    private RestaurantsEntity convert(final RestaurantsDTO restaurant) {
        return restaurantEntityConverter.convert(restaurant);
    }

    private MenuEntity convert(final MenuDTO menu) {
        return menuEntityConverter.convert(menu);
    }

}