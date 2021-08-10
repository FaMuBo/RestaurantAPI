package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.models.converter.dto.RestaurantsDtoConverter;
import com.exampleFinartz.demo.models.converter.entity.fromCreateRequest.RestaurantsCreateRequestToEntityConverter;
import com.exampleFinartz.demo.models.converter.entity.fromUpdateRequest.RestaurantsUpdateRequestToEntityConverter;
import com.exampleFinartz.demo.models.dto.RestaurantsDTO;
import com.exampleFinartz.demo.models.entity.RestaurantsEntity;
import com.exampleFinartz.demo.models.enums.Position;
import com.exampleFinartz.demo.models.request.create.RestaurantsCreateRequest;
import com.exampleFinartz.demo.models.request.update.RestaurantsUpdateRequest;
import com.exampleFinartz.demo.repositories.RestaurantsRepository;
import com.exampleFinartz.demo.services.RestaurantsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantsServiceImpl implements RestaurantsService {

    private final RestaurantsRepository restaurantsRepository;
    private final RestaurantsDtoConverter restaurantsDtoConverter;
    private final RestaurantsCreateRequestToEntityConverter restaurantsCreateRequestToEntityConverter;
    private final RestaurantsUpdateRequestToEntityConverter restaurantsUpdateRequestToEntityConverter;

    @Override
    public List<RestaurantsDTO> getRestaurants(Position position) {
        List<RestaurantsEntity> restaurantsEntities = restaurantsRepository.findByPosition(position);
        List<RestaurantsDTO> restaurants = new ArrayList<>();
        restaurantsEntities.forEach(restaurantsEntity -> {
            restaurants.add(restaurantsDtoConverter.convert(restaurantsEntity));
        });
        return restaurants;
    }

    @Override
    public RestaurantsDTO getRestaurant(Long id) {
        return restaurantsDtoConverter.convert(restaurantsRepository.getById(id));
    }

    @Override
    public RestaurantsDTO createRestaurants(RestaurantsCreateRequest restaurantsCreateRequest) {
        RestaurantsEntity restaurantsEntity = restaurantsCreateRequestToEntityConverter.convert(restaurantsCreateRequest);
        return restaurantsDtoConverter.convert(restaurantsRepository.save(restaurantsEntity));
    }

    @Override
    public RestaurantsDTO updateRestaurants(Long id, RestaurantsUpdateRequest restaurantsUpdateRequest) {
        RestaurantsEntity restaurantsExisted = restaurantsRepository.getById(id);
        RestaurantsEntity restaurantsUpdated =
                restaurantsUpdateRequestToEntityConverter.convert(restaurantsUpdateRequest, restaurantsExisted);

        return restaurantsDtoConverter.convert(restaurantsRepository.save(restaurantsUpdated));

    }

}