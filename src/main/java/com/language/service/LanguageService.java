package com.language.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
@Service
public interface LanguageService {
	/**
	 * @param text     String to check for the QA
	 * @param localeId LocaleId for which we have to check
	 * 
	 * @return List<String> Which are having QA Issues
	 */
	public Optional<List<String>> checkForQA(String text, int localeId);
}

