package com.exampleFinartz.demo.repositories;


import com.exampleFinartz.demo.entity.Branch;
import com.exampleFinartz.demo.enums.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

    List<Branch> findAllByPosition(Position position);

    List<Branch> findByAddress_County_Id(Long county_id);

}