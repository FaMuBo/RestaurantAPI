package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.entity.Address;
import com.exampleFinartz.demo.repositories.AddressRepository;
import com.exampleFinartz.demo.services.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address create(Address address) {
        Address save = addressRepository.save(address);
        return save;
    }

    @Override
    public List<Address> getAll() {
        List<Address> addresses = addressRepository.findAll();
        return addresses;
    }

    @Override
    public Address getById(Long id) {
        Address address = addressRepository.getById(id);
        return address;
    }

    @Override
    public Address update(Address address) {
        Address foundAddress = addressRepository.getById(address.getId());
        if (address.getCity() != null) {
            foundAddress.setCity(address.getCity());
        }
        if (address.getCounty() != null) {
            foundAddress.setCounty(address.getCounty());
        }
        if (address.getDistrict() != null) {
            foundAddress.setDistrict(address.getDistrict());
        }
        if (address.getOther_content() != null) {
            foundAddress.setOther_content(address.getOther_content());
        }
        return addressRepository.save(address);
    }

    @Override
    public Address deleteById(Long id) {
        Address address = addressRepository.getById(id);
        if (address != null) {
            addressRepository.deleteById(id);
            return address;
        }
        return address;
    }

    @Override
    public String delete(Long id) {
        addressRepository.deleteById(id);
        return "SUCCESS";
    }
}


