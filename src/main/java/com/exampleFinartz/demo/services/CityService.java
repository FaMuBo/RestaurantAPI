package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.models.dto.CityDTO;

import java.util.List;

public interface CityService {

    CityDTO getCity(Long id);

    List<CityDTO> getCities();
}