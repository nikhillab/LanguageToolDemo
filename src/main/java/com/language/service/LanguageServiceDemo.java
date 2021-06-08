package com.language.service;

import static java.util.Map.entry;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.languagetool.JLanguageTool;
import org.languagetool.Language;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.language.AngolaPortuguese;
import org.languagetool.language.Arabic;
import org.languagetool.language.Asturian;
import org.languagetool.language.AustralianEnglish;
import org.languagetool.language.BelgianDutch;
import org.languagetool.language.BrazilianPortuguese;
import org.languagetool.language.Breton;
import org.languagetool.language.BritishEnglish;
import org.languagetool.language.CanadianEnglish;
import org.languagetool.language.Catalan;
import org.languagetool.language.Chinese;
import org.languagetool.language.Dutch;
import org.languagetool.language.Esperanto;
import org.languagetool.language.French;
import org.languagetool.language.Galician;
import org.languagetool.language.German;
import org.languagetool.language.Irish;
import org.languagetool.language.Italian;
import org.languagetool.language.Japanese;
import org.languagetool.language.Khmer;
import org.languagetool.language.MozambiquePortuguese;
import org.languagetool.language.NewZealandEnglish;
import org.languagetool.language.Persian;
import org.languagetool.language.Polish;
import org.languagetool.language.PortugalPortuguese;
import org.languagetool.language.Portuguese;
import org.languagetool.language.Romanian;
import org.languagetool.language.Russian;
import org.languagetool.language.Slovak;
import org.languagetool.language.Slovenian;
import org.languagetool.language.SouthAfricanEnglish;
import org.languagetool.language.Spanish;
import org.languagetool.language.Swedish;
import org.languagetool.language.SwissGerman;
import org.languagetool.language.Tamil;
import org.languagetool.language.Ukrainian;
import org.languagetool.language.Ukrainian1992;
import org.languagetool.language.ValencianCatalan;
import org.languagetool.noop.NoopLanguage;
import org.languagetool.rules.RuleMatch;
import org.springframework.stereotype.Service;

import com.language.dto.CheckErrorDto;

@SuppressWarnings("deprecation")
@Service
public class LanguageServiceDemo {
	public static Map<Integer, String> languageSupported = Map.ofEntries(entry(1, "AmericanEnglish"),
			entry(2, "Arabic"), entry(3, "Asturian"), entry(4, "Breton"), entry(5, "AustralianEnglish"),
			entry(6, "BritishEnglish"), entry(7, "CanadianEnglish"), entry(8, "NewZealandEnglish"),
			entry(9, "SouthAfricanEnglish"), entry(10, "Catalan"), entry(11, "ValencianCatalan"), entry(12, "Chinese"),
			entry(13, "Dutch"), entry(14, "BelgianDutch"), entry(17, "Esperanto"), entry(18, "French"),
			entry(19, "Galician"), entry(20, "German"), entry(21, "SwissGerman"), entry(22, "Irish"),
			entry(23, "Italian"), entry(24, "Japanese"), entry(25, "Khmer"), entry(26, "NoopLanguage"),
			entry(27, "Persian"), entry(28, "Polish"), entry(29, "Portuguese"), entry(30, "AngolaPortuguese"),
			entry(31, "BrazilianPortuguese"), entry(32, "MozambiquePortuguese"), entry(33, "PortugalPortuguese"),
			entry(34, "Romanian"), entry(35, "Russian"), entry(36, "Slovak"), entry(37, "Slovenian"),
			entry(38, "Spanish"), entry(39, "Swedish"), entry(40, "Tamil"), entry(41, "Ukrainian"),
			entry(42, "Ukrainian1992")

	);

	private static Language getObject(final int id) {
		switch (id) {

		case 1:
			return new AmericanEnglish();
		case 2:
			return new Arabic();
		case 3:
			return new Asturian();
		case 4:
			return new Breton();
		case 5:
			return new AustralianEnglish();
		case 6:
			return new BritishEnglish();
		case 7:
			return new CanadianEnglish();
		case 8:
			return new NewZealandEnglish();
		case 9:
			return new SouthAfricanEnglish();
		case 10:
			return new Catalan();
		case 11:
			return new ValencianCatalan();
		case 12:
			return new Chinese();
		case 13:
			return new Dutch();
		case 14:
			return new BelgianDutch();
		case 17:
			return new Esperanto();
		case 18:
			return new French();
		case 19:
			return new Galician();
		case 20:
			return new German();
		case 21:
			return new SwissGerman();
		case 22:
			return new Irish();
		case 23:
			return new Italian();
		case 24:
			return new Japanese();
		case 25:
			return new Khmer();
		case 26:
			return new NoopLanguage();
		case 27:
			return new Persian();
		case 28:
			return new Polish();
		case 29:
			return new Portuguese();
		case 30:
			return new AngolaPortuguese();
		case 31:
			return new BrazilianPortuguese();
		case 32:
			return new MozambiquePortuguese();
		case 33:
			return new PortugalPortuguese();
		case 34:
			return new Romanian();
		case 35:
			return new Russian();
		case 36:
			return new Slovak();
		case 37:
			return new Slovenian();
		case 38:
			return new Spanish();
		case 39:
			return new Swedish();
		case 40:
			return new Tamil();
		case 41:
			return new Ukrainian();
		case 42:
			return new Ukrainian1992();
		default:
			throw new IllegalArgumentException("Unexpected value: " + id);
		}

	}

	public static Optional<List<CheckErrorDto>> testString(String text, int id) {
		var langTool = new JLanguageTool(getObject(id));

		try {
			long nanoTime = System.nanoTime();
			List<RuleMatch> check = langTool.check(text);
			System.out.println(System.nanoTime()-nanoTime);

			return Optional.of(createCheckErrorDtoList(check));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	private static List<CheckErrorDto> createCheckErrorDtoList(List<RuleMatch> check) {
		return check.stream().map(convert).collect(Collectors.toList());

	}

	private static Function<RuleMatch, CheckErrorDto> convert = (match) -> {
		return new CheckErrorDto(match.getFromPos(), match.getToPos(), match.getMessage(),
				match.getSuggestedReplacements());
	};
//	List<Language> list = Languages.get();
//	System.err.println(list);
//	System.err.println(Arrays.toString(new French().getCountries()));

//	AustralianEnglish language = new AustralianEnglish();
//	String name = language.getName();
//	System.out.println(name);
//	var langTool = new JLanguageTool(language);
//	List<RuleMatch> check = langTool.check("hello how aer you");
//	String string = langTool.getLanguage().toString();
//	System.out.println(string);
//	check.forEach(e->{
//		System.err.println(e.getSuggestedReplacements());
////		
////	});
//	System.err.println(UUID.randomUUID());
//	System.err.println(UUID.randomUUID());
}