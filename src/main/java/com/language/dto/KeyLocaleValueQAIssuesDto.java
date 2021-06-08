package com.language.dto;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class KeyLocaleValueQAIssuesDto {
	private final UUID id;
	private final UUID projectId;
	private final boolean isIgnored;
	private final UUID keyLocalValueId;
	private final String issueString;
}
