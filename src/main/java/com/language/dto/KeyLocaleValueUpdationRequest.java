package com.language.dto;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class KeyLocaleValueUpdationRequest {

	private final UUID keyLocaleValueUuid;
	private final String value;
	private final Integer localeId;
	private final Integer projectId;

}