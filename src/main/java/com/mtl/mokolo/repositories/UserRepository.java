package com.mtl.mokolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtl.mokolo.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
