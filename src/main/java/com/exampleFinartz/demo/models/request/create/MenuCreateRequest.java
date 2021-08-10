package com.exampleFinartz.demo.models.request.create;

import com.exampleFinartz.demo.models.dto.BranchDTO;
import com.exampleFinartz.demo.models.dto.MealDTO;
import lombok.Data;

import java.util.List;

@Data
public class MenuCreateRequest {
    private long id;
    private BranchDTO branch;
    private List<MealDTO> mealDTOListt;
    private int item_count;
    private List<MealDTO> mealDTOList;
}
