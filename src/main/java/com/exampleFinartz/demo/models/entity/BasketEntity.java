package com.exampleFinartz.demo.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "basket")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder

public class BasketEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "totalPrice")
    private Double totalPrice;

    @OneToMany
    private List<MealEntity> mealEntityList;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToMany
    private List<OrdersEntity> ordersEntity;
}
