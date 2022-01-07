package com.creo.invention.dev.tsyw.repository;

import com.creo.invention.dev.tsyw.model.Category;
import com.creo.invention.dev.tsyw.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findUserByEmail(String email);

    User findUserByUserId(UUID id);

}
