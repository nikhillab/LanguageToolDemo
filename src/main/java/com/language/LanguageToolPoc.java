package com.language;

import java.util.List;
import java.util.UUID;

import org.languagetool.Language;
import org.languagetool.Languages;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.language.SouthAfricanEnglish;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.language.model.MasterQAIssueType;
import com.language.model.KeyLocaleValueQAIssues;
import com.language.model.MasterQARules;
import com.language.model.ProjectQARules;
import com.language.repo.KeyLocaleValueQAIssuesRepo;
import com.language.repo.MasterQAIssueTypeRepo;
import com.language.repo.MasterQARulesRepo;
import com.language.repo.ProjectQARulesRepo;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class LanguageToolPoc implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LanguageToolPoc.class, args);
	}

	private MasterQARulesRepo masterQARulesRepo;

	private MasterQAIssueTypeRepo masterQAIssueTypeRepo;

	private ProjectQARulesRepo projectQARulesRepo;

	private KeyLocaleValueQAIssuesRepo keyLocaleValueQAIssuesRepo;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		List<MasterQARules> list = List.of(new MasterQARules(1, "AmericanEnglish"),
				new MasterQARules(1, "AmericanEnglish"), new MasterQARules(2, "Arabic"),
				new MasterQARules(3, "Asturian"), new MasterQARules(4, "Breton"),
				new MasterQARules(5, "AustralianEnglish"), new MasterQARules(6, "BritishEnglish"),
				new MasterQARules(7, "CanadianEnglish"), new MasterQARules(8, "NewZealandEnglish"),
				new MasterQARules(9, "SouthAfricanEnglish"));
		List<MasterQARules> saveAll = masterQARulesRepo.saveAll(list);
		//System.err.println(saveAll);
		UUID randomUUID = UUID.randomUUID();

		ProjectQARules projectQARules = new ProjectQARules();
		projectQARules.setMasterQARulesId(1);
		projectQARules.setProjectId(randomUUID);

		ProjectQARules save7 = projectQARulesRepo.save(projectQARules);

		projectQARules = new ProjectQARules();
		projectQARules.setMasterQARulesId(9);
		projectQARules.setProjectId(randomUUID);
		ProjectQARules save8 = projectQARulesRepo.save(projectQARules);

		randomUUID = UUID.randomUUID();
		projectQARules = new ProjectQARules();
		projectQARules.setMasterQARulesId(1);
		projectQARules.setProjectId(randomUUID);
		ProjectQARules save = projectQARulesRepo.save(projectQARules);

		projectQARules = new ProjectQARules();
		projectQARules.setMasterQARulesId(2);
		projectQARules.setProjectId(randomUUID);
		ProjectQARules save2 = projectQARulesRepo.save(projectQARules);

//		Language languageForShortCode = Languages.getLanguageForShortCode("ar-kw");
////		System.out.println(languageForShortCode instanceof NewZealandEnglish);

		MasterQAIssueType issueType = new MasterQAIssueType();
		issueType.setIssueString("hella");
		issueType.setMasterQARulesId(3);
		MasterQAIssueType save3 = masterQAIssueTypeRepo.save(issueType);
		issueType = new MasterQAIssueType();
		issueType.setIssueString("ddvd");
		issueType.setMasterQARulesId(1);
		MasterQAIssueType save4 = masterQAIssueTypeRepo.save(issueType);
		issueType = new MasterQAIssueType();
		issueType.setIssueString("wrg");
		issueType.setMasterQARulesId(3);

		MasterQAIssueType save5 = masterQAIssueTypeRepo.save(issueType);

		issueType = new MasterQAIssueType();
		issueType.setIssueString("wefe");
		issueType.setMasterQARulesId(9);
		MasterQAIssueType save6 = masterQAIssueTypeRepo.save(issueType);

		randomUUID = UUID.randomUUID();

		KeyLocaleValueQAIssues qaIssues = new KeyLocaleValueQAIssues();
		qaIssues.setIgnored(false);
		qaIssues.setKeyLocalValueId(randomUUID);
		qaIssues.setMasterQAIssueTypeId(save3.getId());
		qaIssues.setProjectId(save.getProjectId());
		KeyLocaleValueQAIssues save9 = keyLocaleValueQAIssuesRepo.save(qaIssues);

		qaIssues = new KeyLocaleValueQAIssues();
		qaIssues.setIgnored(false);
		qaIssues.setKeyLocalValueId(randomUUID);
		qaIssues.setMasterQAIssueTypeId(save4.getId());
		qaIssues.setProjectId(save.getProjectId());
		KeyLocaleValueQAIssues save10 = keyLocaleValueQAIssuesRepo.save(qaIssues);

		qaIssues = new KeyLocaleValueQAIssues();
		qaIssues.setIgnored(false);
		qaIssues.setKeyLocalValueId(randomUUID);
		qaIssues.setMasterQAIssueTypeId(save5.getId());
		qaIssues.setProjectId(save7.getProjectId());
		KeyLocaleValueQAIssues save11 = keyLocaleValueQAIssuesRepo.save(qaIssues);

//		System.out.println();
//		Language languageForShortCode = Languages.getLanguageForShortCode("ar");
//		System.out.println(languageForShortCode);
	}

}
