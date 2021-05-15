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
		answer.setAnswerText(
				"The number of nodes in each linked list is in the range [1, 100].\r\n" + "0 <= Node.val <= 9\r\n"
						+ "It is guaranteed that the list represents a number that does not have leading zeros.");

		return answer;
	}

	public static AnswerComment getAnswerComment() {
		AnswerComment answer = new AnswerComment();
		answer.setCommentText("ListNode() {}\r\n" + "     ListNode(int val) { this.val = val; }\r\n"
				+ "      ListNode(int val, ListNode next) { this.val = val; this.next = next; }");
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
		question.setQuestionText(
				"You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.");
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
