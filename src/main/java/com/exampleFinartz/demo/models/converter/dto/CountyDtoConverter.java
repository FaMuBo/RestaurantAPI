package com.exampleFinartz.demo.models.converter.dto;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.CityDTO;
import com.exampleFinartz.demo.models.dto.CountyDTO;
import com.exampleFinartz.demo.models.entity.CityEntity;
import com.exampleFinartz.demo.models.entity.CountyEntity;
import org.springframework.stereotype.Component;

@Component
public class CountyDtoConverter implements GenericConverter<CountyEntity, CountyDTO> {

    // private final GenericConverter<AddressEntity, AddressDTO> addressDtoConverter;
    private final GenericConverter<CityEntity, CityDTO> cityDtoConverter;

    public CountyDtoConverter(//@Lazy GenericConverter<AddressEntity, AddressDTO> addressDtoConverter,
                              GenericConverter<CityEntity, CityDTO> cityDtoConverter) {
        // this.addressDtoConverter = addressDtoConverter;
        this.cityDtoConverter = cityDtoConverter;
    }

    @Override
    public CountyDTO convert(final CountyEntity countyEntity) {
        if (countyEntity == null) {
            return null;
        }


        CountyDTO countyDto = new CountyDTO();

        countyDto.setId(countyEntity.getId());
        countyDto.setName(countyEntity.getName());
        countyDto.setCity(convert(countyEntity.getCityEntity()));

        return countyDto;
    }

//    private AddressDTO convert(final AddressEntity addressEntity) {
//        return addressDtoConverter.convert(addressEntity);
//    }

    private CityDTO convert(final CityEntity cityEntity) {
        return cityDtoConverter.convert(cityEntity);
    }
}