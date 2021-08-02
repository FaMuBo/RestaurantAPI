package com.exampleFinartz.demo.services;


import com.exampleFinartz.demo.entities.Address;
import com.exampleFinartz.demo.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address create(Address address) {
        Address save = addressRepository.save(address);
        return save;
    }

    public List<Address> getAll() {
        List<Address> addresses = addressRepository.findAll();
        return addresses;
    }

    public Address getById(Long id) {
        Address address = addressRepository.getById(id);
        return address;
    }

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

    public Address deleteById(Long id) {
        Address address = addressRepository.getById(id);
        if (address != null) {
            addressRepository.deleteById(id);
            return address;
        }
        return address;
    }

    public String delete(long id) {
        addressRepository.deleteById(id);
        return "SUCCESS";
    }
}

