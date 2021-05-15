package com.question.controller;

import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.question.forms.QuestionForm;
import com.question.model.Question;
import com.question.model.QuestionLike;
import com.question.service.QuestionService;

@RestController
public class QuestionController {

	@GetMapping("/question/{questionId}")
	public ResponseEntity<Question> getQuestionsById(@PathVariable Long questionId) {

		Optional<Question> findById = questionService.findById(questionId);
		if (findById.isPresent()) {
			return new ResponseEntity<Question>(findById.get(), HttpStatus.OK);

		}

		return new ResponseEntity<Question>(HttpStatus.NOT_FOUND);

	}

	@PostMapping("/question")
	public ResponseEntity<Question> createQuestion(@Valid @RequestBody QuestionForm questionForm) {
		// call question service and save it and return id
		Question save = questionService.saveQuestionForm(questionForm);

		return new ResponseEntity<Question>(save, HttpStatus.OK);
	}

	@PostMapping("/question/like")
	public ResponseEntity<Void> likeQuestion(@RequestBody QuestionLike questionLike) {
		return questionService.saveQuestionLike(questionLike);
	}

	@GetMapping("question/filter")
	public ResponseEntity<Set<Question>> getFilterQuestionList(
			@RequestParam(required = false, defaultValue = "") String company,
			@RequestParam(required = false, defaultValue = "") String subTopic,
			@RequestParam(required = false, defaultValue = "") String tag,
			@RequestParam(required = false, defaultValue = "") String date) {

		Set<Question> filterQuestion = questionService.getFilterQuestion(company, subTopic, tag, date);

		return new ResponseEntity<Set<Question>>(filterQuestion, HttpStatus.OK);

	}

	private QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}

}
