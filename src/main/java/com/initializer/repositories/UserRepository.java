package com.initializer.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.initializer.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}
