package com.dnoviy.controlSystem.repository;

import com.dnoviy.controlSystem.entity.ERole;
import com.dnoviy.controlSystem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);

}
