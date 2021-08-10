package com.exampleFinartz.demo.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "ordersEntity")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder

public class OrdersEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name = "amount")
    private int amount;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    private BasketEntity basketEntity;


}
