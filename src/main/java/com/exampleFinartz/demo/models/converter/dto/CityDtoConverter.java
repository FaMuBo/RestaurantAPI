package com.exampleFinartz.demo.models.converter.dto;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.AddressDTO;
import com.exampleFinartz.demo.models.dto.CityDTO;
import com.exampleFinartz.demo.models.dto.CountyDTO;
import com.exampleFinartz.demo.models.entity.AddressEntity;
import com.exampleFinartz.demo.models.entity.CityEntity;
import com.exampleFinartz.demo.models.entity.CountyEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CityDtoConverter implements GenericConverter<CityEntity, CityDTO> {

    private final GenericConverter<AddressEntity, AddressDTO> addressDtoConverter;
    private final GenericConverter<CountyEntity, CountyDTO> countyDtoConverter;

    @Override
    public CityDTO convert(final CityEntity cityEntity) {
        if (cityEntity == null) {
            return null;
        }

        CityDTO cityDto = new CityDTO();

        cityDto.setId(cityEntity.getId());
        cityDto.setName(cityEntity.getName());


        return cityDto;

    }

    private AddressDTO convert(final AddressEntity addressEntity) {
        return addressDtoConverter.convert(addressEntity);
    }

    private CountyDTO convert(final CountyEntity countyEntity) {
        return countyDtoConverter.convert(countyEntity);
    }


}
