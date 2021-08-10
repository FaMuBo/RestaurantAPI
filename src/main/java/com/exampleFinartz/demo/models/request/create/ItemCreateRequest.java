package com.exampleFinartz.demo.models.request.create;

import com.exampleFinartz.demo.models.dto.MealDTO;
import lombok.Data;

import java.util.List;

@Data
public class ItemCreateRequest {

    private String name;
    private long id;
    private List<MealDTO> mealDTOList;
}
