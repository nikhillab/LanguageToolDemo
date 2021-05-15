package com.question.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.question.dao.TopicRepository;
import com.question.model.Topic;

@RestController
public class TopicController {
	private TopicRepository topicRepository;

	@GetMapping("/topic/{topicId}")
	public ResponseEntity<Topic> getTopicById(@PathVariable Long topicId) {

		Optional<Topic> findById = topicRepository.findById(topicId);
		if (findById.isPresent()) {
			return new ResponseEntity<Topic>(findById.get(), HttpStatus.OK);
		}

		return new ResponseEntity<Topic>(HttpStatus.NOT_FOUND);

	}

	@GetMapping("/topics")
	public ResponseEntity<Iterable<Topic>> getTopicList() {
		return new ResponseEntity<Iterable<Topic>>(topicRepository.findAll(), HttpStatus.OK);

	}

	@PostMapping("/topic")
	public ResponseEntity<Topic> createTopic(@RequestBody Topic topic) {

		Topic save = topicRepository.save(topic);
		return new ResponseEntity<Topic>(save, HttpStatus.CREATED);

	}

	@PutMapping("/topic")
	public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic) {

		boolean findById = topicRepository.existsById(topic.getTopicId());

		if (findById) {
			Topic save = topicRepository.save(topic);
			return new ResponseEntity<Topic>(save, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/topic/{topicId}")
	public ResponseEntity<Topic> deleteTopic(@PathVariable Long topicId) {

		boolean findById = topicRepository.existsById(topicId);
		if (findById) {
			topicRepository.deleteById(topicId);
			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	public TopicController(TopicRepository topicRepository) {
		this.topicRepository = topicRepository;
	}

}
