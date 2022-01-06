package com.creo.invention.dev.tsyw.repository;

import com.creo.invention.dev.tsyw.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role getByRoleName(String name);

}
