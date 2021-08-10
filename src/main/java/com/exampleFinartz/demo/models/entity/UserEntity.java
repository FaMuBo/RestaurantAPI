package com.exampleFinartz.demo.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder

public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private long password;
    private String name;
    private String email;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "role")
//    private Role role;

    @OneToOne
    private BasketEntity basketEntity;

    @OneToMany
    private List<CardInfoEntity> cardinfo;

    @OneToMany(mappedBy = "userEntity")
    @JsonIgnore
    private List<AddressEntity> addressEntities;

    @OneToMany(mappedBy = "userEntity")
    private List<CommentsEntity> commentsEntities;

    @OneToMany(mappedBy = "userEntity")
    @JsonIgnore
    private List<RestaurantsEntity> restaurantsEntities;


}
