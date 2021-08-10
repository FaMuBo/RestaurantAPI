package com.exampleFinartz.demo.models.converter.dto;

import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.*;
import com.exampleFinartz.demo.models.entity.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AddressDtoConverter implements GenericConverter<AddressEntity, AddressDTO> {


    private final GenericConverter<CityEntity, CityDTO> cityDTOConverter;
    private final GenericConverter<CountyEntity, CountyDTO> countyDTOConverter;
    private final GenericConverter<UserEntity, UserDTO> userDTOConverter;
    private final GenericConverter<BranchEntity, BranchDTO> branchDTOConverter;

    @Override
    public AddressDTO convert(final AddressEntity addressEntity) {
        if (addressEntity == null) {
            return null;
        }

        AddressDTO address = new AddressDTO();

        address.setId(addressEntity.getId());
        address.setName(addressEntity.getName());
        address.setCity(convert(addressEntity.getCityEntity()));
        address.setCounty(convert(addressEntity.getCountyEntity()));
        address.setDistrict(addressEntity.getDistrict());
        address.setOther_content(addressEntity.getOther_content());
        address.setUser(convert(addressEntity.getUserEntity()));
        address.setBranch(convert(addressEntity.getBranchEntity()));

        return address;

    }

    private CityDTO convert(final CityEntity cityEntity) {
        return cityDTOConverter.convert(cityEntity);
    }

    private CountyDTO convert(final CountyEntity countyEntity) {
        return countyDTOConverter.convert(countyEntity);
    }

    private UserDTO convert(final UserEntity userEntity) {
        return userDTOConverter.convert(userEntity);
    }

    private BranchDTO convert(final BranchEntity branchEntity) {
        return branchDTOConverter.convert(branchEntity);
    }

}
