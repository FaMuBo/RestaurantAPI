package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entity.County;

import java.util.List;


public interface CountyService {
    public County create(County county);

    public List<County> getAll();

    public County getById(Long id);

    public County update(County county);

    public County deleteById(Long id);

    String delete(Long id);

}
