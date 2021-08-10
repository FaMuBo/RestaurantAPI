package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.models.converter.dto.CityDtoConverter;
import com.exampleFinartz.demo.models.dto.CityDTO;
import com.exampleFinartz.demo.models.entity.CityEntity;
import com.exampleFinartz.demo.repositories.CityRepository;
import com.exampleFinartz.demo.services.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    private final CityDtoConverter cityDtoConverter;

    @Override
    public CityDTO getCity(Long id) {
        CityEntity cityEntity = cityRepository.getById(id);
        return cityDtoConverter.convert(cityEntity);
    }

    @Override
    public List<CityDTO> getCities() {
        List<CityEntity> cityEntities = cityRepository.findAll();
        List<CityDTO> cities = new ArrayList<>();
        cityEntities.forEach(cityEntity -> {
            cities.add(cityDtoConverter.convert(cityEntity));
        });
        return cities;
    }


}
