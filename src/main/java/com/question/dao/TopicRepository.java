package com.question.dao;

import org.springframework.data.repository.CrudRepository;

import com.question.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, Long> {

}