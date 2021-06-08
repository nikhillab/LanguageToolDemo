package com.language.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.languagetool.JLanguageTool;
import org.languagetool.Language;
import org.languagetool.Languages;
import org.languagetool.rules.RuleMatch;
import org.springframework.stereotype.Service;

import com.language.model.Locale;
import com.language.repo.LocaleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LanguageTool implements LanguageService {

	private LocaleRepository localeRepository;

	@Override
	public Optional<List<String>> checkForQA(String text, int localeId) {
		Optional<Locale> locale = localeRepository.findById(localeId);
		Language language = null;
		if (locale.isPresent()) {
			try {
				language = Languages.getLanguageForShortCode(locale.get().getName());
			} catch (IllegalArgumentException argumentException) { // if the given name is not supported
				try {
					// try to get the default language
					// EX: [en-in] then [en] as default
					language = Languages.getLanguageForShortCode(locale.get().getName().substring(0, 2));

				} catch (IllegalArgumentException argumentException2) {

					// if no language found then return empty QA
					return Optional.empty();
				}
			}
			// create the object for the corresponding language and check the string
			var langTool = new JLanguageTool(language);

			try {
				var results = langTool.check(text);
				return Optional.of(parseMatchResults(results, text));

			} catch (IOException e) {
				e.printStackTrace();
				return Optional.empty();
			}

		}
		return Optional.of(List.of());
	}

	private List<String> parseMatchResults(List<RuleMatch> results, String text) {
		return results.stream().map(err -> text.substring(err.getFromPos(), err.getToPos()))
				.collect(Collectors.toList());

	}
}