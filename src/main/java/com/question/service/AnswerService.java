package com.question.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.question.dao.AnswerCommentRepository;
import com.question.dao.AnswerLikeRepository;
import com.question.dao.AnswerRepository;
import com.question.model.Answer;
import com.question.model.AnswerComment;
import com.question.model.AnswerLike;
import com.question.model.Question;
import com.question.model.User;

@Service
public class AnswerService {

	private AnswerRepository answerRepository;

	private QuestionService questionService;
	private UserService userService;
	private AnswerLikeRepository answerLikeRepository;
	private AnswerCommentRepository answerCommentRepository;

	/**
	 * @return List<Answer>
	 */
	public List<Answer> findAll() {
		return answerRepository.findAll();
	}

	// save answer
	/**
	 * @param Answer answer
	 * @return
	 * @return Answer
	 */
	public ResponseEntity<Answer> save(Answer answer) {
		Optional<User> findUser = userService.findById(answer.getUserId());
		Optional<Question> findQuestion = questionService.findById(answer.getQuestionId());
		
		if (findQuestion.isPresent() && findUser.isPresent()) {
			Answer save = answerRepository.save(answer);

			// add answer to user answer list
			User user = findUser.get();
			user.setAnswers(save);
			userService.save(user);

			Question question = findQuestion.get();
			question.setAnswers(save);
			questionService.save(question);

			return new ResponseEntity<Answer>(save, HttpStatus.OK);

		}

		return new ResponseEntity<Answer>(HttpStatus.BAD_REQUEST);
	}

	// save answer like
	/**
	 * @param AnswerLike answerLike
	 * @return
	 */
	public ResponseEntity<Void> saveAnswerLike(AnswerLike answerLike) {

		Optional<User> findUser = userService.findById(answerLike.getUserId());

		Optional<Answer> findAnswer = answerRepository.findById(answerLike.getAnswerId());

		if (findAnswer.isPresent() && findUser.isPresent()) {

			AnswerLike save = answerLikeRepository.save(answerLike);

			Answer answer = findAnswer.get();
			answer.setAnswerLikes(save);
			answerRepository.save(answer);

			// add answer like to user list
			User user = findUser.get();
			user.setAnswerLikes(save);
			userService.save(user);

			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);

		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);

	}

	public ResponseEntity<Void> saveComment(AnswerComment answerComment) {

		Optional<User> findUser = userService.findById(answerComment.getUserId());

		Optional<Answer> findAnswer = answerRepository.findById(answerComment.getAnswerId());

		if (findAnswer.isPresent() && findUser.isPresent()) {

			AnswerComment save = answerCommentRepository.save(answerComment);

			Answer answer = findAnswer.get();
			answer.setAnswerComments(save);
			answerRepository.save(answer);

			// add answer like to user list
			User user = findUser.get();
			user.setAnswerComments(save);
			userService.save(user);

			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);

		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);

	}

	// call question to add answer

	/**
	 * @param answerRepository
	 */
	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}

	/**
	 * @param userService
	 */
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * @param questionService the questionService to set
	 */
	@Autowired
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	/**
	 * @param answerLikeRepository the answerLikeRepository to set
	 */
	@Autowired
	public void setAnswerLikeRepository(AnswerLikeRepository answerLikeRepository) {
		this.answerLikeRepository = answerLikeRepository;
	}

	/**
	 * @param answerCommentRepository the answerCommentRepository to set
	 */
	@Autowired
	public void setAnswerCommentRepository(AnswerCommentRepository answerCommentRepository) {
		this.answerCommentRepository = answerCommentRepository;
	}

}
