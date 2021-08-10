package com.exampleFinartz.demo.models.entity;

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

public class ItemEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "unit_type")
    private String unitType;

    @ManyToMany(mappedBy = "itemsEntities")
    private List<MealEntity> mealEntityList;


}
