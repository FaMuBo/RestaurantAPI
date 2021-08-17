package com.exampleFinartz.demo.models.converter.dto;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.CityDTO;
import com.exampleFinartz.demo.models.entity.CityEntity;
import org.springframework.stereotype.Component;

@Component

public class CityDtoConverter implements GenericConverter<CityEntity, CityDTO> {

    //  private final GenericConverter<AddressEntity, AddressDTO> addressDtoConverter;
    // private final GenericConverter<CountyEntity, CountyDTO> countyDtoConverter;

    // public CityDtoConverter(@Lazy GenericConverter<AddressEntity, AddressDTO> addressDtoConverter,
    //   @Lazy GenericConverter<CountyEntity, CountyDTO> countyDtoConverter) {

//        this.addressDtoConverter = addressDtoConverter;
//        this.countyDtoConverter = countyDtoConverter;
//    }

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
//
//    private AddressDTO convert(final AddressEntity addressEntity) {
//        return addressDtoConverter.convert(addressEntity);
//    }
//
//    private CountyDTO convert(final CountyEntity countyEntity) {
//        return countyDtoConverter.convert(countyEntity);
//    }


}
