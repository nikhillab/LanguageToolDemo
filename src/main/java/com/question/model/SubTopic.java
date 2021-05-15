package com.question.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SubTopic {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long subTopicId;

	private String subTopicName;


	@Column(name = "TOPIC_ID")
	private Long topicId;

	public String getSubTopicName() {
		return subTopicName;
	}

	public void setSubTopicName(String subTopicName) {
		this.subTopicName = subTopicName;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public Long getSubTopicId() {
		return subTopicId;
	}

	@Override
	public String toString() {
		return String.format("SubTopic [subTopicId=%s, subTopicName=%s, topicId=%s]", subTopicId, subTopicName,
				topicId);
	}
}
