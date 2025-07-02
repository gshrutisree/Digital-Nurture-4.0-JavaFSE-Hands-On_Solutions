
package com.example.ex1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ex1.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
