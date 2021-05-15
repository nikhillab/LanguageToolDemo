package com.question.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class AnswerComment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long commentId;

	@Min(value = 50, message = "Min length 50 characters")
	@Max(value = 500, message = "Max length 500 characters")
	private String commentText;

	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "ANSWER_ID")
	private Long answerId;

	private LocalDate date = LocalDate.now();

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
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

	public Long getCommentId() {
		return commentId;
	}

	public LocalDate getDate() {
		return date;
	}

	@Override
	public String toString() {
		return String.format("AnswerComment [commentId=%s, commentText=%s, userId=%s, answerId=%s, date=%s]", commentId,
				commentText, userId, answerId, date);
	}

}
