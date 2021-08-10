package com.exampleFinartz.demo.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class MenuDTO {
    private long id;
    private BranchDTO branch;
    private List<MealDTO> mealDTOListt;
    private int item_count;
    private List<MealDTO> mealDTOList;
//
//    public void setBranchEntity(BranchDTO convert) {
//    }
}
