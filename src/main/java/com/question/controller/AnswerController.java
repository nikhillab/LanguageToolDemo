package com.question.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.question.model.Answer;
import com.question.model.AnswerComment;
import com.question.model.AnswerLike;
import com.question.service.AnswerService;

@RestController
public class AnswerController {

	@PostMapping("/answer")
	public ResponseEntity<Answer> createAnswer(@RequestBody Answer answer) {

		if (answer.getAnswerText().length() > 500 || answer.getAnswerText().length() < 50) {
			throw new RuntimeException(". Min length 50 characters, Max length 500 characters");
		}

		return answerService.save(answer);
	}

	@GetMapping("/answer")
	public List<Answer> getAnswers() {
		return answerService.findAll();
	}

	@PostMapping("/answer/like")
	public ResponseEntity<Void> createAnswerLike(@RequestBody AnswerLike answerLike) {
		return answerService.saveAnswerLike(answerLike);

	}

	@PostMapping("/answer/comment")
	public ResponseEntity<Void> createAnswerComment(@RequestBody AnswerComment answerComment) {
		if (answerComment.getCommentText().length() > 500 || answerComment.getCommentText().length() < 50) {
			throw new RuntimeException(". Min length 50 characters, Max length 500 characters");
		}
		return answerService.saveComment(answerComment);
	}

	private AnswerService answerService;

	public AnswerController(AnswerService answerService) {
		this.answerService = answerService;
	}

}
