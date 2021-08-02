package com.exampleFinartz.demo.entities;

import com.exampleFinartz.demo.enums.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "RESTAURANTS")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
//USER_id nasıl tutturulmalı sor
public class Restaurants {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    private List<Branch> branch;


}
