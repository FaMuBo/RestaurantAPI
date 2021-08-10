package com.exampleFinartz.demo.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class MealDTO {
    private long id;
    private String name;
    private int price;
    private List<ItemDTO> itemDTOList;
    private MenuDTO menu;
    private ItemDTO item;

//    public void setMenuEntity(MenuDTO convert) {
//    }
}
