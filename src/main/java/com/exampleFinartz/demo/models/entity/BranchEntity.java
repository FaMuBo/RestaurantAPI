package com.exampleFinartz.demo.models.entity;

import com.exampleFinartz.demo.models.enums.Position;
import com.exampleFinartz.demo.models.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Table(name = "branch")
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class BranchEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    private Position position;

    @Column(name = "speed_rate")
    private int speed_rate;

    @Column(name = "taste_rate")
    private int taste_rate;

    @Column(name = "vote_count")
    private int vote_rate;

    @Column(name = "comment_count")
    private int comment_count;

    @OneToMany
    private List<CommentsEntity> comments;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantsEntity restaurantEntity;

    @OneToOne(mappedBy = "branchEntity")
    private MenuEntity menuEntity;

    @OneToOne(mappedBy = "branchEntity", fetch = FetchType.LAZY)
    private AddressEntity addressEntity;

}
