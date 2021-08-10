package com.exampleFinartz.demo.models.converter.entity.fromDTO;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.CityDTO;
import com.exampleFinartz.demo.models.dto.CountyDTO;
import com.exampleFinartz.demo.models.entity.CityEntity;
import com.exampleFinartz.demo.models.entity.CountyEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CountyDtoToEntityConverter implements GenericConverter<CountyDTO, CountyEntity> {

    private final GenericConverter<CityDTO, CityEntity> cityEntityConverter;

    @Override
    public CountyEntity convert(final CountyDTO county) {
        if (county == null) {
            return null;
        }

        CountyEntity countyEntity = new CountyEntity();

        countyEntity.setId(county.getId());
        countyEntity.setName(county.getName());
        countyEntity.setCityEntity(convert(county.getCity()));

        return countyEntity;
    }

    private CityEntity convert(final CityDTO city) {
        return cityEntityConverter.convert(city);
    }

}
