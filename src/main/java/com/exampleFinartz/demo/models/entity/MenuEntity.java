package com.exampleFinartz.demo.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "menu")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder

public class MenuEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int item_count;


    @OneToMany
    private List<MealEntity> meallistt;

    @OneToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "id", nullable = false)
    private BranchEntity branchEntity;

    @OneToMany(mappedBy = "menuEntity", cascade = CascadeType.ALL)
    private List<MealEntity> mealEntities;


}