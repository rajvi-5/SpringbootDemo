package com.practice.springboot.repository;

import com.practice.springboot.model.User1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User1,Integer> {
}
