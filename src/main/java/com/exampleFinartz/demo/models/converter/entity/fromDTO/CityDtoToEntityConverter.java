package com.exampleFinartz.demo.models.converter.entity.fromDTO;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.CityDTO;
import com.exampleFinartz.demo.models.entity.CityEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CityDtoToEntityConverter implements GenericConverter<CityDTO, CityEntity> {


    @Override
    public CityEntity convert(final CityDTO city) {
        if (city == null) {
            return null;
        }

        CityEntity cityEntity = new CityEntity();

        cityEntity.setId(city.getId());
        cityEntity.setName(city.getName());

        return cityEntity;
    }

}