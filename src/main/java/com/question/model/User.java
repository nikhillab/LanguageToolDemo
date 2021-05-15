package com.question.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Long userId;

	private String userName;

	@OneToMany(cascade = CascadeType.REMOVE, targetEntity = Question.class)
	@JoinColumn(name = "USER_ID")
	private List<Question> questions = new ArrayList<>();

	@OneToMany(cascade = CascadeType.REMOVE, targetEntity = Answer.class)
	@JoinColumn(name = "USER_ID")
	private List<Answer> answers = new ArrayList<>();

	@OneToMany(cascade = CascadeType.REMOVE, targetEntity = QuestionLike.class)
	@JoinColumn(name = "USER_ID")
	private List<QuestionLike> questionLikes = new ArrayList<>();

	@OneToMany(cascade = CascadeType.REMOVE, targetEntity = AnswerLike.class)
	@JoinColumn(name = "USER_ID")
	private List<AnswerLike> answerLikes = new ArrayList<>();

	@OneToMany(cascade = CascadeType.REMOVE, targetEntity = AnswerComment.class)
	@JoinColumn(name = "USER_ID")
	private List<AnswerComment> answerComments = new ArrayList<>();

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Question question) {
		this.questions.add(question);
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Answer answer) {
		this.answers.add(answer);
	}

	public List<QuestionLike> getQuestionLikes() {
		return questionLikes;
	}

	public void setQuestionLikes(QuestionLike questionLike) {
		this.questionLikes.add(questionLike);
	}

	public List<AnswerLike> getAnswerLikes() {
		return answerLikes;
	}

	public void setAnswerLikes(AnswerLike answerLike) {
		this.answerLikes.add(answerLike);
	}

	public List<AnswerComment> getAnswerComments() {
		return answerComments;
	}

	public void setAnswerComments(AnswerComment answerComment) {
		this.answerComments.add(answerComment);
	}

	public Long getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return String.format(
				"User [userId=%s, userName=%s, questions=%s, answers=%s, questionLikes=%s, answerLikes=%s, answerComments=%s]",
				userId, userName, questions, answers, questionLikes, answerLikes, answerComments);
	}

}
