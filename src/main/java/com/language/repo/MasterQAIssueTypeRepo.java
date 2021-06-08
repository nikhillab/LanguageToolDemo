package com.language.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.language.model.MasterQAIssueType;

public interface MasterQAIssueTypeRepo extends JpaRepository<MasterQAIssueType, UUID> {

}