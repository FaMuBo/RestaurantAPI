package com.exampleFinartz.demo.models.request.update;

import com.exampleFinartz.demo.models.dto.MealDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuUpdateRequest {

    private List<MealDTO> meals;
}
