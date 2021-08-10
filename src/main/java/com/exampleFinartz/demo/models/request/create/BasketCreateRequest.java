package com.exampleFinartz.demo.models.request.create;

import com.exampleFinartz.demo.models.dto.MealDTO;
import com.exampleFinartz.demo.models.dto.OrdersDTO;
import com.exampleFinartz.demo.models.dto.UserDTO;
import lombok.Data;

import java.util.List;

@Data
public class BasketCreateRequest {

    private Long id;
    private Double totalprice;
    private List<MealDTO> mealDTOList;
    private UserDTO user;
    private List<OrdersDTO> ordersDTOList;
}
