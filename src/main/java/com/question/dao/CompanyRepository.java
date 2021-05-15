package com.question.dao;

import org.springframework.data.repository.CrudRepository;

import com.question.model.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {

}