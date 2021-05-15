package com.question.dao;

import org.springframework.data.repository.CrudRepository;

import com.question.model.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {

}