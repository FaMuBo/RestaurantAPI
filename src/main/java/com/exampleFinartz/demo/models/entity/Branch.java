//package com.exampleFinartz.demo.models.entity;
//
//import com.exampleFinartz.demo.enums.Position;
//import com.exampleFinartz.demo.enums.Role;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Data
//@Builder
//@Table(name = "ŞUBE")
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
////restaurant menü idler
//public class Branch {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//    private String name;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "role")
//    private Role role;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "position")
//    private Position position;
//
//    @Column(name = "speed_rate")
//    private int speed_rate;
//
//    @Column(name = "taste_rate")
//    private int taste_rate;
//
//    @Column(name = "vote_count")
//    private int vote_count;
//
//    @Column(name = "comment_count")
//    private int comment_count;
//
//    @OneToOne
//    private Menu menu;
//
//    @OneToMany
//    private List<Comments> comments;
//
//    @ManyToOne
//    @JoinColumn(name = "restaurant_id")
//    private Restaurants restaurants;
//
//    @OneToOne(mappedBy = "branch", fetch = FetchType.LAZY)
//    private Address address;
//
//}
