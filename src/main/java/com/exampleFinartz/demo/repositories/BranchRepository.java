package com.exampleFinartz.demo.repositories;


import com.exampleFinartz.demo.models.entity.BranchEntity;
import com.exampleFinartz.demo.models.enums.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<BranchEntity, Long> {

    List<BranchEntity> getBranchEntitiesByPosition(Position position);

    List<BranchEntity> getBranchEntitiesByAddressEntity_CountyEntity_Id(Long countyId);
}