package com.example.expensetrackerapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.expensetrackerapi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Boolean existsByEmail(String email);

	Optional<User> findByEmail(String email);
}
