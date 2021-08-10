package com.exampleFinartz.demo.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Table(name = "city")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CityEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToOne
    private AddressEntity addressEntity;

    @OneToMany
    private List<CountyEntity> countyEntity;
}
