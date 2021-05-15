package com.question.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.question.dao.CompanyRepository;
import com.question.dao.QuestionLikeRepository;
import com.question.dao.QuestionRepository;
import com.question.dao.SubTopicRepository;
import com.question.dao.TagRepository;
import com.question.forms.QuestionForm;
import com.question.model.Question;
import com.question.model.QuestionLike;
import com.question.model.User;

@Service
public class QuestionService {

	private QuestionRepository questionRepository;

	private TagRepository tagRepository;
	private CompanyRepository companyRepository;
	private SubTopicRepository subTopicRepository;
	private UserService userService;
	private QuestionLikeRepository questionLikeRepository;

	public Question save(Question question) {
		return questionRepository.save(question);
	}

	// save question with validation
	public Question saveQuestionForm(QuestionForm questionForm) {
		Question question = new Question();
		question.setSubTopic(subTopicRepository.findById(questionForm.getSubTopicId())
				.orElseThrow(() -> new RuntimeException("Sub Topic not found with ID" + questionForm.getSubTopicId())));

		Optional<User> findUser = userService.findById(questionForm.getUserId());
		question.setUserId(
				findUser.orElseThrow(() -> new RuntimeException("User not found with ID" + questionForm.getUserId()))
						.getUserId());

		question.setQuestionText(questionForm.getQuestionText());

		for (var tag : questionForm.getTagList()) {
			boolean existsById = tagRepository.existsById(tag.getTagId());
			if (existsById)
				question.setTag(tag);
			else
				throw new RuntimeException("Tag not found with ID" + tag.getTagId());
		}

		question.setCompany(companyRepository.findById(questionForm.getCompanyId())
				.orElseThrow(() -> new RuntimeException("Company not found with ID" + questionForm.getCompanyId())));

		Question savedQuestion = questionRepository.save(question);

		// add to question list of the given user
		User user = findUser.get();
		user.setQuestions(savedQuestion);
		userService.save(user);

		return savedQuestion;

	}

	// find question by id
	public Optional<Question> findById(Long questionId) {
		return questionRepository.findById(questionId);
	}

	// save question likes
	public ResponseEntity<Void> saveQuestionLike(QuestionLike questionLike) {

		Optional<User> findUser = userService.findById(questionLike.getUserId());
		Optional<Question> findQuestion = questionRepository.findById(questionLike.getQuestionId());

		if (findQuestion.isPresent() && findUser.isPresent()) {
			QuestionLike save = questionLikeRepository.save(questionLike);

			Question question = findQuestion.get();
			question.setQuestionLikes(save);
			questionRepository.save(question);

			// add to question like list of the given user
			User user = findUser.get();
			user.setQuestionLikes(save);
			userService.save(user);

			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);

	}

	/**
	 * @param company
	 * @param subTopic
	 * @param tag
	 * @param date
	 * @return Set<Question>
	 */
	public Set<Question> getFilterQuestion(String company, String subTopic, String tag, String date) {
		Set<Question> resultSet = new HashSet<>();
		String[] companyListQuery = company.split(",");
		String[] subTopicListQuery = subTopic.split(",");
		String[] tagListQuery = tag.split(",");
		String[] dateListQuery = date.split(",");

		List<Question> questionList = questionRepository.findAll();

		// checking by company
		for (var question : questionList) {
			var companyList = question.getCompany();
			for (var comp : companyList) {
				for (var companyQuery : companyListQuery) {
					if (comp.getCompanyName().equalsIgnoreCase(companyQuery)) {
						resultSet.add(question);
					}
				}
			}
		}

		// checking for subtopics
		for (var question : questionList) {
			var subTopicList = question.getSubTopic();
			for (var subtopic : subTopicList) {
				for (var subTopicQuery : subTopicListQuery) {
					if (subtopic.getSubTopicName().equalsIgnoreCase(subTopicQuery))
						resultSet.add(question);

				}
			}
		}
		// checking for tags
		for (var question : questionList) {
			var tagList = question.getTag();
			for (var tag1 : tagList) {
				for (var tagQuery : tagListQuery) {
					if (tag1.getTagName().equalsIgnoreCase(tagQuery))
						resultSet.add(question);

				}
			}
		}

		// checking for tags
		for (var question : questionList) {
			var questionDate = question.getDate().toString();
			for (var dateQuery : dateListQuery) {
				if (questionDate.equalsIgnoreCase(dateQuery))
					resultSet.add(question);
			}
		}

		return resultSet;
	}

	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;

	}

	@Autowired
	public void setTagRepository(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}

	@Autowired
	public void setCompanyRepository(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Autowired
	public void setSubTopicRepository(SubTopicRepository subTopicRepository) {
		this.subTopicRepository = subTopicRepository;
	}

	@Autowired
	public void setUserService(UserService userRepository) {
		this.userService = userRepository;
	}

	@Autowired
	public void setQuestionLikeRepository(QuestionLikeRepository questionLikeRepository) {
		this.questionLikeRepository = questionLikeRepository;
	}

}
