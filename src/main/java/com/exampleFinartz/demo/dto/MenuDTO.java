package com.exampleFinartz.demo.dto;

import com.exampleFinartz.demo.entity.Branch;
import com.exampleFinartz.demo.entity.Meal;
import lombok.Data;

import java.util.List;

@Data
public class MenuDTO {
    private long id;
    private Branch branch;
    private List<Meal> meallistt;
    private int item_count;
    private List<Meal> meal;

    public void setBranch(BranchDTO convert) {
    }
}
