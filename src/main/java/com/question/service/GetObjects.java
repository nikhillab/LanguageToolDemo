package com.question.service;

import org.springframework.stereotype.Service;

import com.question.model.Answer;
import com.question.model.AnswerComment;
import com.question.model.AnswerLike;
import com.question.model.Company;
import com.question.model.Question;
import com.question.model.QuestionLike;
import com.question.model.SubTopic;
import com.question.model.Tag;
import com.question.model.Topic;
import com.question.model.User;

@Service
public class GetObjects {

	public static Answer getAnswer() {
		Answer answer = new Answer();
		answer.setAnswerText("Use two stack to implement to solve the question");

		return answer;
	}

	public static AnswerComment getAnswerComment() {
		AnswerComment answer = new AnswerComment();
		answer.setCommentText("solved using stack data structure");
		return answer;
	}

	public static AnswerLike getAnswerLike() {
		AnswerLike answerLike = new AnswerLike();
		return answerLike;
	}

	public static Company getCompany() {
		Company company = new Company();
		company.setCompanyName("TCS");

		return company;
	}

	public static QuestionLike getQuestionLike() {
		QuestionLike questionLike = new QuestionLike();
		return questionLike;

	}

	public static Question getQuestion() {
		Question question = new Question();
		question.setQuestionText("Min Stack in O(1) Time");
		return question;
	}

	public static SubTopic getSubTopic() {
		SubTopic subTopic = new SubTopic();
		subTopic.setSubTopicName("Stack");

		return subTopic;

	}

	public static Topic getTopic() {
		Topic topic = new Topic();
		topic.setTopicName("Data Structure");
		return topic;
	}

	public static Tag getTag() {
		Tag tag = new Tag();
		tag.setTagName("#Stack");
		return tag;
	}

	public static User getUser() {
		User user = new User();
		user.setUserName("Nikhil Kumar");

		return user;

	}
}
