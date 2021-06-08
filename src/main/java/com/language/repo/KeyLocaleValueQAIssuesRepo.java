package com.language.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.language.model.KeyLocaleValueQAIssues;

public interface KeyLocaleValueQAIssuesRepo extends JpaRepository<KeyLocaleValueQAIssues, UUID> {

	List<KeyLocaleValueQAIssues> findByProjectId(UUID projectId);

	List<KeyLocaleValueQAIssues> findBykeyLocalValueId(UUID keyLocalValueId);

}