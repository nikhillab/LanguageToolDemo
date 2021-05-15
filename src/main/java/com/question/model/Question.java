package com.question.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "QUESTION_ID")
	private Long questionId;

	private String questionText;

	@Column(name = "USER_ID")
	private Long userId;

	@OneToMany(cascade = CascadeType.REMOVE, targetEntity = Answer.class)
	@JoinColumn(name = "QUESTION_ID")
	private List<Answer> answers = new ArrayList<>();

	@ManyToMany
	private Set<SubTopic> subTopic = new HashSet<>();

	@ManyToMany
	private Set<Company> company = new HashSet<>();

	@ManyToMany
	private Set<Tag> tag = new HashSet<>();

	@OneToMany(cascade = CascadeType.REMOVE, targetEntity = QuestionLike.class)
	@JoinColumn(name = "QUESTION_ID")
	private List<QuestionLike> questionLikes = new ArrayList<>();

	private LocalDate date = LocalDate.now();

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Answer question) {
		this.answers.add(question);
	}

	public Set<SubTopic> getSubTopic() {
		return subTopic;
	}

	public void setSubTopic(SubTopic subTopic) {
		this.subTopic.add(subTopic);
	}

	public Set<Company> getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company.add(company);
	}

	public Set<Tag> getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag.add(tag);
	}

	public List<QuestionLike> getQuestionLikes() {
		return questionLikes;
	}

	public void setQuestionLikes(QuestionLike questionLike) {
		this.questionLikes.add(questionLike);
	}

	public Long getQuestionId() {
		return questionId;
	}

	public LocalDate getDate() {
		return date;
	}

	@Override
	public String toString() {
		return String.format(
				"Question [questionId=%s, questionText=%s, userId=%s, answers=%s, subTopic=%s, company=%s, tag=%s, questionLikes=%s, date=%s]",
				questionId, questionText, userId, answers, subTopic, company, tag, questionLikes, date);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answers == null) ? 0 : answers.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((questionId == null) ? 0 : questionId.hashCode());
		result = prime * result + ((questionLikes == null) ? 0 : questionLikes.hashCode());
		result = prime * result + ((questionText == null) ? 0 : questionText.hashCode());
		result = prime * result + ((subTopic == null) ? 0 : subTopic.hashCode());
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (answers == null) {
			if (other.answers != null)
				return false;
		} else if (!answers.equals(other.answers))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (questionId == null) {
			if (other.questionId != null)
				return false;
		} else if (!questionId.equals(other.questionId))
			return false;
		if (questionLikes == null) {
			if (other.questionLikes != null)
				return false;
		} else if (!questionLikes.equals(other.questionLikes))
			return false;
		if (questionText == null) {
			if (other.questionText != null)
				return false;
		} else if (!questionText.equals(other.questionText))
			return false;
		if (subTopic == null) {
			if (other.subTopic != null)
				return false;
		} else if (!subTopic.equals(other.subTopic))
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
