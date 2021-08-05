//package com.exampleFinartz.demo.models.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Data
//@Table(name = "MENÜ")
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Builder
////enable ,şube id koyulmadı nasıl tutturulacak?
//public class Menu {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//
//    @Column(name = "item_count")
//    private int item_count;
//
//
//    @OneToMany
//    private List<Meal> meallistt;
//
//    @OneToOne
//    @JoinColumn(name = "branch_id")
//    private Branch branch;
//
//    @OneToMany
//    private List<Meal> meal;
//
//
//}