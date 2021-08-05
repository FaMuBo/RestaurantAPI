package com.exampleFinartz.demo.entity;

import com.exampleFinartz.demo.enums.Role;
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

public class User extends BaseDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "password")
    private long password;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "email")
    private String email;

    @OneToOne
    private Basket basket;

    @OneToMany
    private List<CardInfo> cardi̇nfo;

    @OneToMany
    private List<Address> adress;

    @OneToMany
    private List<Comments> comments;

    @OneToMany
    private List<Restaurants> restaurants;


}
