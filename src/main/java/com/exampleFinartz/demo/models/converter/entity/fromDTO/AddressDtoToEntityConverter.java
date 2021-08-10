package com.exampleFinartz.demo.models.converter.entity.fromDTO;


import com.exampleFinartz.demo.models.converter.GenericConverter;
import com.exampleFinartz.demo.models.dto.*;
import com.exampleFinartz.demo.models.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressDtoToEntityConverter implements GenericConverter<AddressDTO, AddressEntity> {

    private final GenericConverter<CityDTO, CityEntity> cityEntityConverter;
    private final GenericConverter<CountyDTO, CountyEntity> countyEntityConverter;
    private final GenericConverter<UserDTO, UserEntity> userEntityConverter;
    private final GenericConverter<BranchDTO, BranchEntity> branchEntityConverter;

    @Override
    public AddressEntity convert(final AddressDTO address) {
        if (address == null) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setId(address.getId());
        addressEntity.setName(address.getName());
        addressEntity.setDistrict(address.getDistrict());
        addressEntity.setOther_content(address.getOther_content());
        addressEntity.setCityEntity(convert(address.getCity()));
        addressEntity.setCountyEntity(convert(address.getCounty()));
        addressEntity.setUserEntity(convert(address.getUser()));
        addressEntity.setBranchEntity(convert(address.getBranch()));

        return addressEntity;

    }

    private CityEntity convert(final CityDTO city) {
        return cityEntityConverter.convert(city);
    }

    private CountyEntity convert(final CountyDTO county) {
        return countyEntityConverter.convert(county);
    }

    private UserEntity convert(final UserDTO user) {
        return userEntityConverter.convert(user);
    }

    private BranchEntity convert(final BranchDTO branch) {
        return branchEntityConverter.convert(branch);
    }

}