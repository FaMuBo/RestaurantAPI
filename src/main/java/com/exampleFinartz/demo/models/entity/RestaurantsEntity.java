package com.exampleFinartz.demo.models.entity;

import com.exampleFinartz.demo.models.enums.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "restaurants")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder

public class RestaurantsEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20) default 'WAITING' ")
    private Position position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity userEntity;

    @OneToMany(mappedBy = "restaurantEntity")
    private List<BranchEntity> branchEntities;


}
