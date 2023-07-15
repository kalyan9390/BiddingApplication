package com.bidding.Controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bidding.Entity.User;
import com.bidding.Service.UserService;

@RestController
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/user/save")
	public String createUser(@RequestBody User user, Model model) {
		User user1 = userService.createUser(user);

		return user1.toString();
	}

	@GetMapping("/user/get/{id}")
	public User getUserById(@PathVariable Long id) {
		User user = userService.getUserById(id);
		return user;
	}

	@GetMapping("/user/getAll")
	public List<User> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return users;
	}

	@PutMapping("/user/update/{id}")
	public User updateUser(@PathVariable User user, Long id) {
		User user1 = userService.updateUser(user, id);
		return user1;
	}

	@DeleteMapping("/user/delete/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}

}
