package com.language.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.language.dto.KeyLocaleValueQAIssuesDto;
import com.language.model.KeyLocaleValueQAIssues;
import com.language.repo.KeyLocaleValueQAIssuesRepo;
import com.language.service.LanguageService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
class QAController {

	private LanguageService languageService;
	private KeyLocaleValueQAIssuesRepo issuesRepo;

	@GetMapping("v1/qa/project/{projectId}")
	public List<KeyLocaleValueQAIssuesDto> getQAByProjectId(@PathVariable UUID projectId) {
		List<KeyLocaleValueQAIssues> listOfKeyLocaleValueQAIssues = issuesRepo.findByProjectId(projectId);
		return listOfKeyLocaleValueQAIssues.stream()
				.map(issue -> KeyLocaleValueQAIssuesDto.builder().isIgnored(issue.isIgnored())
						.issueString(issue.getMasterQAIssueType().getIssueString()).id(issue.getId())
						.keyLocalValueId(issue.getKeyLocalValueId()).projectId(issue.getProjectId()).build())
				.collect(Collectors.toList());

	}

	@GetMapping("v1/qa/keylocale/{keyLocalValueId}")
	public List<KeyLocaleValueQAIssuesDto> getQAByKeyLocalValueId(@PathVariable UUID keyLocalValueId) {
		List<KeyLocaleValueQAIssues> listOfKeyLocaleValueQAIssues = issuesRepo.findBykeyLocalValueId(keyLocalValueId);
		return listOfKeyLocaleValueQAIssues.stream()
				.map(issue -> KeyLocaleValueQAIssuesDto.builder().isIgnored(issue.isIgnored())
						.issueString(issue.getMasterQAIssueType().getIssueString()).id(issue.getId())
						.keyLocalValueId(issue.getKeyLocalValueId()).projectId(issue.getProjectId()).build())
				.collect(Collectors.toList());
	}

	@PostMapping("v1/qa/check")
	public List<String> checkQA(@RequestParam String text, @RequestParam int localeId) {

		long currentTimeMillis = System.currentTimeMillis();

		var checkForQA = languageService.checkForQA(text, localeId);
		System.err.println(System.currentTimeMillis() - currentTimeMillis);

		if (checkForQA.isPresent()) {
			return checkForQA.get();
		} else
			return List.of();

	}

	@PutMapping("v1/qa/key_locale_value_qa_issues/{issuesId}")
	public HttpStatus setIsisIgnored(@PathVariable UUID issuesId) {
		var findById = issuesRepo.findById(issuesId);
		if (findById.isPresent()) {
			var keyLocaleValueQAIssues = findById.get();
			keyLocaleValueQAIssues.setIgnored(true);
			issuesRepo.save(keyLocaleValueQAIssues);
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;

	}

	@GetMapping("v1/get")
	public List<KeyLocaleValueQAIssuesDto> getKeyLocaleValueQAIssues() {

		List<KeyLocaleValueQAIssues> listOfKeyLocaleValueQAIssues = issuesRepo.findAll();
		return listOfKeyLocaleValueQAIssues.stream()
				.map(issue -> KeyLocaleValueQAIssuesDto.builder().isIgnored(issue.isIgnored())
						.issueString(issue.getMasterQAIssueType().getIssueString()).id(issue.getId())
						.keyLocalValueId(issue.getKeyLocalValueId()).projectId(issue.getProjectId()).build())
				.collect(Collectors.toList());
	}

}