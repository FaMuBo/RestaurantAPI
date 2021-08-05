package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entity.Meal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MealService {

    public Meal create(Meal meal);

    public List<Meal> getAll();

    public Meal getById(Long id);

    public Meal update(Meal meal);

    public Meal deleteById(Long id);

    String delete(Long id);


}
