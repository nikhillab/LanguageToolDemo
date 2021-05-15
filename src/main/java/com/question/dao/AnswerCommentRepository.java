package com.question.dao;

import org.springframework.data.repository.CrudRepository;

import com.question.model.AnswerComment;

public interface AnswerCommentRepository extends CrudRepository<AnswerComment, Long> {

}

