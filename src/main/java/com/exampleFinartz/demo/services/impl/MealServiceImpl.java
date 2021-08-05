package com.exampleFinartz.demo.services.impl;

import com.exampleFinartz.demo.entity.Meal;
import com.exampleFinartz.demo.repositories.MealRepository;
import com.exampleFinartz.demo.services.MealService;

import java.util.List;

public class MealServiceImpl implements MealService {


    private MealRepository mealRepository;

    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public Meal create(Meal meal) {
        Meal save = mealRepository.save(meal);
        return save;
    }

    @Override
    public List<Meal> getAll() {
        List<Meal> meals = mealRepository.findAll();
        return meals;
    }

    @Override
    public Meal getById(Long id) {
        Meal meal = mealRepository.getById(id);
        return meal;
    }

    @Override
    public Meal update(Meal meal) {
        Meal foundMeal = mealRepository.getById(meal.getId());
        if (meal.getName() != null) {
            foundMeal.setName(meal.getName());
        }
        if (meal.getPrice() != 0) {
            foundMeal.setName(meal.getName());
        }
        return mealRepository.save(meal);
    }

    @Override
    public Meal deleteById(Long id) {
        Meal meal = mealRepository.getById(id);
        if (meal != null) {
            mealRepository.deleteById(id);
            return meal;
        }
        return meal;
    }

    @Override
    public String delete(Long id) {
        mealRepository.deleteById(id);
        return "SUCCESS";
    }
}
