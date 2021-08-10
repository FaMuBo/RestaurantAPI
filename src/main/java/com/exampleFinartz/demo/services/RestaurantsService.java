package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.models.dto.RestaurantsDTO;
import com.exampleFinartz.demo.models.enums.Position;
import com.exampleFinartz.demo.models.request.create.RestaurantsCreateRequest;
import com.exampleFinartz.demo.models.request.update.RestaurantsUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantsService {

    List<RestaurantsDTO> getRestaurants(Position position);

    RestaurantsDTO getRestaurant(Long id);

    RestaurantsDTO createRestaurants(RestaurantsCreateRequest restaurantsCreateRequest);

    RestaurantsDTO updateRestaurants(Long id, RestaurantsUpdateRequest restaurantsUpdateRequest);
}