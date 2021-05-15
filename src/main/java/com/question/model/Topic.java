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
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TOPIC_ID")
	private Long topicId;

	private String topicName;
	
	@OneToMany(cascade = CascadeType.REMOVE, targetEntity = SubTopic.class)
	@JoinColumn(name = "TOPIC_ID")
	private List<SubTopic> subTopics = new ArrayList<>();

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public List<SubTopic> getSubTopics() {
		return subTopics;
	}

	public void setSubTopics(SubTopic subTopic) {
		this.subTopics.add(subTopic);
	}

	public Long getTopicId() {
		return topicId;
	}

	@Override
	public String toString() {
		return String.format("Topic [topicId=%s, topicName=%s, subTopics=%s]", topicId, topicName, subTopics);
	}

}
