package com.exampleFinartz.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "meal")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder

public class Meal extends BaseDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "meal_name")
    private String name;

    @Column(name = "price")
    private int price;

    @ManyToMany
    @JoinColumn(name = "item_id")
    private List<Item> items;

    @ManyToOne
    @JoinColumn(name = "menü_id", nullable = false)
    private Menu menu;


}


