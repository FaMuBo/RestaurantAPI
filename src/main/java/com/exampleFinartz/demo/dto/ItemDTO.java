package com.exampleFinartz.demo.dto;

import com.exampleFinartz.demo.entity.Meal;
import lombok.Data;

import java.util.List;

@Data
public class ItemDTO {
    private String name;
    private long id;
    private List<Meal> mealList;
}
