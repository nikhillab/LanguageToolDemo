package com.language.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.language.model.ProjectQARules;

public interface ProjectQARulesRepo extends JpaRepository<ProjectQARules, UUID> {

}