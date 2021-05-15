package com.question.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.question.dao.UserRepository;
import com.question.model.User;

@Service
public class UserService {

	private UserRepository userRepository;

	/**
	 * @param userId
	 * @return Optional<User>
	 */
	public Optional<User> findById(Long userId) {
		return userRepository.findById(userId);

	}

	/**
	 * @param user
	 * @return User
	 */
	public User save(User user) {
		return userRepository.save(user);

	}

	/**
	 * @param userRepository
	 */
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
