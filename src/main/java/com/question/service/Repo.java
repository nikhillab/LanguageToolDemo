package com.question.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.dao.AnswerCommentRepository;
import com.question.dao.AnswerLikeRepository;
import com.question.dao.AnswerRepository;
import com.question.dao.CompanyRepository;
import com.question.dao.QuestionLikeRepository;
import com.question.dao.QuestionRepository;
import com.question.dao.SubTopicRepository;
import com.question.dao.TagRepository;
import com.question.dao.TopicRepository;
import com.question.dao.UserRepository;

@Service
public class Repo {

	@Autowired
	public AnswerCommentRepository answerCommentRepository;
	@Autowired
	public AnswerLikeRepository answerLikeRepository;
	@Autowired
	public AnswerRepository answerRepository;
	@Autowired
	public CompanyRepository companyRepository;
	@Autowired
	public UserRepository userRepository;
	@Autowired
	public QuestionLikeRepository questionLikeRepository;
	@Autowired
	public QuestionRepository questionRepository;
	@Autowired
	public SubTopicRepository subTopicRepository;
	@Autowired
	public TopicRepository topicRepository;
	@Autowired
	public TagRepository tagRepository;

}
