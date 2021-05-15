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

import com.question.dao.SubTopicRepository;
import com.question.model.SubTopic;

@RestController
public class SubTopicController {
	private SubTopicRepository subTopicRepository;

	@GetMapping("/subTopic/{subTopicId}")
	public ResponseEntity<SubTopic> getTopicById(@PathVariable Long subTopicId) {

		Optional<SubTopic> findById = subTopicRepository.findById(subTopicId);
		if (findById.isPresent()) {
			return new ResponseEntity<SubTopic>(findById.get(), HttpStatus.OK);
		}

		return new ResponseEntity<SubTopic>(HttpStatus.NOT_FOUND);

	}

	@GetMapping("/subTopics")
	public ResponseEntity<Iterable<SubTopic>> getTopicList() {
		return new ResponseEntity<Iterable<SubTopic>>(subTopicRepository.findAll(), HttpStatus.OK);

	}

	@PostMapping("/subTopic")
	public ResponseEntity<SubTopic> createTopic(@RequestBody SubTopic subTopic) {

		SubTopic save = subTopicRepository.save(subTopic);
		return new ResponseEntity<SubTopic>(save, HttpStatus.CREATED);

	}

	@PutMapping("/subTopic")
	public ResponseEntity<SubTopic> updateTopic(@RequestBody SubTopic subTopic) {

		System.out.println(subTopic);
		boolean findById = subTopicRepository.existsById(subTopic.getTopicId());

		if (findById) {
			SubTopic save = subTopicRepository.save(subTopic);
			return new ResponseEntity<SubTopic>(save, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/subTopic/{subTopicId}")
	public ResponseEntity<SubTopic> deleteTopic(@PathVariable Long subTopicId) {

		boolean findById = subTopicRepository.existsById(subTopicId);
		if (findById) {
			subTopicRepository.deleteById(subTopicId);
			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	public SubTopicController(SubTopicRepository subTopicRepository) {
		this.subTopicRepository = subTopicRepository;
	}
}
