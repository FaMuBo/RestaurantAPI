package com.exampleFinartz.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder

public class Item extends BaseDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "items")
    private List<Meal> mealList;


}
