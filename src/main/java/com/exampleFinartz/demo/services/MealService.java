package com.exampleFinartz.demo.services;

import com.exampleFinartz.demo.entities.Meal;
import com.exampleFinartz.demo.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    public Meal create(Meal meal) {
        Meal save = mealRepository.save(meal);
        return save;
    }

    public List<Meal> getAll() {
        List<Meal> meals = mealRepository.findAll();
        return meals;
    }

    public Meal getById(Long id) {
        Meal meal = mealRepository.getById(id);
        return meal;
    }

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

    public Meal deleteById(Long id) {
        Meal meal = mealRepository.getById(id);
        if (meal != null) {
            mealRepository.deleteById(id);
            return meal;
        }
        return meal;
    }

    public String delete(long id) {
        mealRepository.deleteById(id);
        return "SUCCESS";
    }
}
