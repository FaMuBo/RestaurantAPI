package com.exampleFinartz.demo.services;


import com.exampleFinartz.demo.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface AddressService {

    public Address create(Address address);

    public List<Address> getAll();

    public Address getById(Long id);

    public Address update(Address address);

    public Address deleteById(Long id);

    String delete(Long id);

}

