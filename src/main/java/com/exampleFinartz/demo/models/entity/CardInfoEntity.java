package com.exampleFinartz.demo.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Table(name = "cardınfo")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CardInfoEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "card_no")
    private String card_no;

    @Column(name = "name")
    private String name;

    @Column(name = "exp_year")
    private String exp_year;

    @Column(name = "exp_month")
    private String exp_month;

    @Column(name = "cvv")
    private String cvv;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;
}
