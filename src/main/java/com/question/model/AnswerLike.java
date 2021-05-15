package com.question.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AnswerLike {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long answerLikeId;


	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "ANSWER_ID")
	private Long answerId;

	public Long getAnswerLikeId() {
		return answerLikeId;
	}


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}


	@Override
	public String toString() {
		return String.format("AnswerLike [answerLikeId=%s, userId=%s, answerId=%s]", answerLikeId, userId, answerId);
	}
}