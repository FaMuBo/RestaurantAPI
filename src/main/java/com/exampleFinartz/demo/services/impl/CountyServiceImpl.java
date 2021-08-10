package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.models.converter.dto.CountyDtoConverter;
import com.exampleFinartz.demo.models.dto.CountyDTO;
import com.exampleFinartz.demo.models.entity.CountyEntity;
import com.exampleFinartz.demo.repositories.CountyRepository;
import com.exampleFinartz.demo.services.CountyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountyServiceImpl implements CountyService {

    private final CountyRepository countyRepository;
    private final CountyDtoConverter countyDtoConverter;

    @Override
    public CountyDTO getCounty(Long id) {
        CountyEntity countyEntity = countyRepository.getById(id);
        return countyDtoConverter.convert(countyEntity);
    }
}
