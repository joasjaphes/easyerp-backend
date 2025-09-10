package com.jcom.easyerp.repositories;

import com.jcom.easyerp.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUid(String uid);
}
