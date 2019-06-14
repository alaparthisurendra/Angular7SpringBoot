package com.user.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
