package com.question.dao;

import org.springframework.data.repository.CrudRepository;

import com.question.model.QuestionLike;

public interface QuestionLikeRepository extends CrudRepository<QuestionLike, Long> {

}