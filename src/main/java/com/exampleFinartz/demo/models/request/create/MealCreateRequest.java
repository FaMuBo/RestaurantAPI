package com.exampleFinartz.demo.models.request.create;

import com.exampleFinartz.demo.models.dto.ItemDTO;
import com.exampleFinartz.demo.models.dto.MenuDTO;
import lombok.Data;

import java.util.List;

@Data
public class MealCreateRequest {
    private long id;
    private String name;
    private int price;
    private List<ItemDTO> itemDTOList;
    private MenuDTO menu;

}
