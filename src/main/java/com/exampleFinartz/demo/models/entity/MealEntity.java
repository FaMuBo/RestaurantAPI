package com.exampleFinartz.demo.models.entity;

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

public class MealEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "meal_id")
    private long id;

    private String name;

    private int price;

    @ManyToMany()
//    @JoinColumn()
    @JoinTable(name = "item_meal",
            joinColumns = @JoinColumn(name = "meal_id", nullable = false)
            , inverseJoinColumns = @JoinColumn(name = "item_id", nullable = false))
    private List<ItemEntity> itemsEntities;

    @ManyToOne
    @JoinColumn(name = "menu_id", referencedColumnName = "id", nullable = false)
    private MenuEntity menuEntity;

}


