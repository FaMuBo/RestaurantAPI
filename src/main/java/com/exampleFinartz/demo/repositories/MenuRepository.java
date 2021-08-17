package com.exampleFinartz.demo.repositories;

import com.exampleFinartz.demo.models.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
    MenuEntity getMenuEntityByBranchEntity_Id(Long branch_id);
}
