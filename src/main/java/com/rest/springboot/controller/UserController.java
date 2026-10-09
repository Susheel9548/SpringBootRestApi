package com.rest.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.springboot.dao.UserRepository;
import com.rest.springboot.entity.User;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepositary;
	
	public UserController(UserRepository userRepositary) {
		super();
		this.userRepositary = userRepositary;
	}
	
	


	@GetMapping
	public User greet() {
		System.out.println("Usercontroller.greet() :");

		return new User(99, "Dummy", "No gender", "Planet not found");
	}

	@GetMapping("/{id}")
	public Optional<User> pathVariable(@PathVariable(name = "id") int id) {
		System.out.println("Usercontroller.pathVariable() :" + id);

		return userRepositary.findById(id);
	}

	@GetMapping("/all-users")
	public List<User> getAllUsers() {
		System.out.println("Usercontroller.getAllUsers()");
		
		return userRepositary.findAll();

		
	}

	@PostMapping
	public User saveUser(@RequestBody User user) {
		System.out.println("Usercontroller.saveUser :");
		System.out.println(user);

		userRepositary.save(user);

		return user;
	}  
	
}
