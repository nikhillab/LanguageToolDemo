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
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ANSWER_ID")
	private Long answerId;

	private String answerText;

	@Column(name = "QUESTION_ID")
	private Long questionId;

	@Column(name = "USER_ID")
	private Long userId;

	@OneToMany(cascade = CascadeType.REMOVE, targetEntity = AnswerComment.class)
	@JoinColumn(name = "ANSWER_ID")
	private List<AnswerComment> answerComments = new ArrayList<>();

	@OneToMany(cascade = CascadeType.REMOVE, targetEntity = AnswerLike.class)
	@JoinColumn(name = "ANSWER_ID")
	private List<AnswerLike> answerLikes = new ArrayList<>();

	public Long getAnswerId() {
		return answerId;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<AnswerComment> getAnswerComments() {
		return answerComments;
	}

	public void setAnswerComments(AnswerComment answerComment) {
		this.answerComments.add(answerComment);
	}

	public List<AnswerLike> getAnswerLikes() {
		return answerLikes;
	}

	public void setAnswerLikes(AnswerLike answerLike) {
		this.answerLikes.add(answerLike);
	}

	@Override
	public String toString() {
		return String.format(
				"Answer [answerId=%s, answerText=%s, questionId=%s, userId=%s, answerComments=%s, answerLikes=%s]",
				answerId, answerText, questionId, userId, answerComments, answerLikes);
	}

}
