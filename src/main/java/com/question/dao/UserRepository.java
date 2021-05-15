package com.question.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.question.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
