package com.user.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.user.model.User;
import com.user.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateuser(Long id, User user) {
		user.setId(id);
		return userRepository.save(user);	
	}
	
	public List<User> getAllUsers() {
		List<User> allusers = new ArrayList<>();
		userRepository.findAll().forEach(allusers::add);
		return allusers;
	}
	
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}
	
	public Optional<User> findUserById(long id) {
		return userRepository.findById(id);
	}
}
