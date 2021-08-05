package com.exampleFinartz.demo.request;

import com.exampleFinartz.demo.entity.Meal;
import lombok.Data;

import java.util.List;

@Data
public class ItemCreateRequest {
    private String name;
    private long id;
    private List<Meal> mealList;
}
