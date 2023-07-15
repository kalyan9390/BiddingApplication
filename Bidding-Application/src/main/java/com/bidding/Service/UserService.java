package com.bidding.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bidding.Entity.User;
import com.bidding.Repository.UserRepo;

@Service
public class UserService {

	private UserRepo userRepo;

	public UserService(UserRepo userRepository) {
		this.userRepo = userRepository;
	}

	public User createUser(User user) {

		// Save the user to the repository
		return userRepo.save(user);
	}

	public User updateUser(User user, Long id) {
		// Find the user by ID
		Optional<User> optional = userRepo.findById(id);

		// Update the user properties
		User user1 = optional.get();
		user1.setId(id);
		user1.setUsername(user.getUsername());

		return userRepo.save(user1);
	}

	public void deleteUser(Long id) {

		userRepo.deleteById(id);
	}

	public User getUserById(Long id) {
		// Find the user by ID
		return userRepo.findById(id).get();
	}

	public List<User> getAllUsers() {
		// Get all users from the repository
		return (List<User>) userRepo.findAll();
	}

}
