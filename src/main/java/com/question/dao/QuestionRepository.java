package com.question.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.question.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}