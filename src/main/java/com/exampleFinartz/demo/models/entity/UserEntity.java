package com.exampleFinartz.demo.models.entity;

import com.exampleFinartz.demo.models.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "users")

public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String password;
    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user", joinColumns = @JoinColumn(name = "id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private List<Role> roles;

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
