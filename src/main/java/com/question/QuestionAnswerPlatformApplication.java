package com.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

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
import com.question.service.GetObjects;
import com.question.service.Repo;

@SpringBootApplication
public class QuestionAnswerPlatformApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(QuestionAnswerPlatformApplication.class, args);
	}

	@Autowired
	Repo repo;

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		// to update data in the database for checking purpos

		User user = repo.userRepository.save(GetObjects.getUser());

		Topic topic = GetObjects.getTopic();
		topic = repo.topicRepository.save(topic);

		SubTopic subTopic = GetObjects.getSubTopic();
		subTopic.setTopicId(topic.getTopicId());
		subTopic = repo.subTopicRepository.save(subTopic);

		topic.setSubTopics(subTopic);
		topic = repo.topicRepository.save(topic);

		Tag tag = GetObjects.getTag();
		tag = repo.tagRepository.save(tag);

		Company company = GetObjects.getCompany();
		company = repo.companyRepository.save(company);

		Question question = GetObjects.getQuestion();
		question.setCompany(company);
		question.setSubTopic(subTopic);
		question.setUserId(user.getUserId());
		question.setTag(tag);
		question = repo.questionRepository.save(question);

		user.setQuestions(question);
		user = repo.userRepository.save(user);

		QuestionLike questionLike = GetObjects.getQuestionLike();
		questionLike.setUserId(user.getUserId());
		questionLike.setQuestionId(question.getQuestionId());
		questionLike = repo.questionLikeRepository.save(questionLike);

		question.setQuestionLikes(questionLike);
		question = repo.questionRepository.save(question);

		user.setQuestionLikes(questionLike);
		user = repo.userRepository.save(user);

		Answer answer = GetObjects.getAnswer();
		answer.setQuestionId(question.getQuestionId());
		answer.setUserId(user.getUserId());
		answer = repo.answerRepository.save(answer);

		question.setAnswers(answer);
		question = repo.questionRepository.save(question);

		user.setAnswers(answer);
		user = repo.userRepository.save(user);

		AnswerComment answerComment = GetObjects.getAnswerComment();
		answerComment.setUserId(user.getUserId());
		answerComment.setAnswerId(answer.getAnswerId());
		answerComment = repo.answerCommentRepository.save(answerComment);

		answer.setAnswerComments(answerComment);
		answer = repo.answerRepository.save(answer);

		user.setAnswerComments(answerComment);
		user = repo.userRepository.save(user);

		AnswerLike answerLike = GetObjects.getAnswerLike();
		answerLike.setUserId(user.getUserId());
		answerLike.setAnswerId(answer.getAnswerId());
		answerLike = repo.answerLikeRepository.save(answerLike);

		answer.setAnswerLikes(answerLike);
		answer = repo.answerRepository.save(answer);

		user.setAnswerLikes(answerLike);
		user = repo.userRepository.save(user);

	}

}
