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
//@Table(name = "BASKET")
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Builder
//
//public class Basket {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//
//    @Column(name = "totalPrice")
//    private Double totalPrice;
//
//    @OneToMany
//    private List<Meal> mealList;
//
//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @OneToMany
//    private List<Orders> orders;
//}
