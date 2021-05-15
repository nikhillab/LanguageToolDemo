package com.question.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuestionLike {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionLikeId;
	
	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "QUESTION_ID")
	private Long questionId;

	public Long getQuestionLikeId() {
		return questionLikeId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	@Override
	public String toString() {
		return String.format("QuestionLike [questionLikeId=%s, userId=%s, questionId=%s]", questionLikeId, userId,
				questionId);
	}
}
