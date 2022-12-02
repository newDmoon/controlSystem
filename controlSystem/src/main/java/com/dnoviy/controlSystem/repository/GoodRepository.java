package com.dnoviy.controlSystem.repository;

import com.dnoviy.controlSystem.entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodRepository extends JpaRepository<Good, Long> {
    Good getGoodById(Long id);
}
