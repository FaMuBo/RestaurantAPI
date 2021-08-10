package com.exampleFinartz.demo.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Table(name = "county")
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class CountyEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private CityEntity cityEntity;

    @OneToOne
    private AddressEntity addressEntity;
}

