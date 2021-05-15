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

import com.question.dao.TagRepository;
import com.question.model.Tag;

@RestController
public class TagController {

	private TagRepository tagRepository;

	@GetMapping("/tag/{tagId}")
	public ResponseEntity<Tag> getTopicById(@PathVariable Long tagId) {

		Optional<Tag> findById = tagRepository.findById(tagId);
		if (findById.isPresent()) {
			return new ResponseEntity<Tag>(findById.get(), HttpStatus.OK);
		}

		return new ResponseEntity<Tag>(HttpStatus.NOT_FOUND);

	}

	@GetMapping("/tags")
	public ResponseEntity<Iterable<Tag>> getTopicList() {
		return new ResponseEntity<Iterable<Tag>>(tagRepository.findAll(), HttpStatus.OK);

	}

	@PostMapping("/tag")
	public ResponseEntity<Tag> createTopic(@RequestBody Tag tag) {

		Tag save = tagRepository.save(tag);
		return new ResponseEntity<Tag>(save, HttpStatus.CREATED);

	}

	@PutMapping("/tag")
	public ResponseEntity<Tag> updateTopic(@RequestBody Tag tag) {

		boolean findById = tagRepository.existsById(tag.getTagId());

		if (findById) {
			Tag save = tagRepository.save(tag);
			return new ResponseEntity<Tag>(save, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/tag/{tagId}")
	public ResponseEntity<Tag> deleteTopic(@PathVariable Long tagId) {

		boolean findById = tagRepository.existsById(tagId);
		if (findById) {
			tagRepository.deleteById(tagId);
			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	public TagController(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}
}
