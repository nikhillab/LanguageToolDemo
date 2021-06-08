package com.language.repo;

import static java.util.Map.entry;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.language.model.Locale;

@Component
public class LocaleRepository {

	private Map<Integer, Locale> locale = Map.ofEntries(entry(1, new Locale("en-us")), entry(2, new Locale("ar")),
			entry(3, new Locale("en-as")), entry(4, new Locale("de-de")), entry(5, new Locale("en-au")),
			entry(6, new Locale("en-gb")), entry(7, new Locale("en-ca")), entry(8, new Locale("en-nz")),
			entry(9, new Locale("en-za"))

	);

	public Optional<Locale> findById(int localeId) {
		Locale value = locale.get(localeId);
		return Optional.ofNullable(value);
	}

}
