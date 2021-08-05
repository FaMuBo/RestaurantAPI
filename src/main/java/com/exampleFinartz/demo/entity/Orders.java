package com.exampleFinartz.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
//USER RESTAURANT CARD idler?
public class Orders extends BaseDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name = "amount")
    private int amount;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    private Basket basket;


}
