package com.exampleFinartz.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Table(name = "ADDRESS")
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "other_content", nullable = false)
    private String other_content;

    @OneToOne
    @JoinColumn(name = "county_id", nullable = false)
    private County county;

    @OneToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

}



