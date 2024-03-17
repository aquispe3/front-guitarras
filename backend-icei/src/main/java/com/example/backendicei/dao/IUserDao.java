package com.example.backendicei.dao;


import com.example.backendicei.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserDao extends JpaRepository<UserEntity,Integer> {
    Optional<UserEntity> findByUsername(String username);
}
