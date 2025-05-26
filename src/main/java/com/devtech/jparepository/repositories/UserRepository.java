package com.devtech.jparepository.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devtech.jparepository.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
