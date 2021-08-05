package com.exampleFinartz.demo.dto;

import com.exampleFinartz.demo.entity.Item;
import com.exampleFinartz.demo.entity.Menu;
import lombok.Data;

import java.util.List;

@Data
public class MealDTO {
    private long id;
    private String name;
    private int price;
    private List<Item> items;
    private Menu menu;

    public void setMenu(MenuDTO convert) {
    }
}
