package com.question.forms;

import java.util.ArrayList;
import java.util.List;

import com.question.model.Tag;

public class QuestionForm {
	private String questionText;
	private Long companyId;
	private Long subTopicId;
	private List<Tag> tagList = new ArrayList<>();
	private Long userId;

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getSubTopicId() {
		return subTopicId;
	}

	public void setSubTopicId(Long subTopicId) {
		this.subTopicId = subTopicId;
	}

	public List<Tag> getTagList() {
		return tagList;
	}

	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return String.format("QuestionForm [questionText=%s, companyId=%s, subTopicId=%s, tagList=%s, userId=%s]",
				questionText, companyId, subTopicId, tagList, userId);
	}

}
