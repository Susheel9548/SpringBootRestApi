package com.rest.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.springboot.entity.User;

@RestController
public class UserController {
	static Map<Integer, User> users = new HashMap<>();

	static {
		users.put(1, new User(1, "Anuj", "Male", "Noida"));
		users.put(2, new User(2, "Kunal", "Male", "Haryana"));
		users.put(3, new User(3, "Nikil", "Male", "Delhi"));
		users.put(4, new User(4, "Anmol", "Male", "Gurgaon"));
		users.put(5, new User(5, "Arjun", "Male", "Noida"));

	}

	@GetMapping
	public User greet() {
		System.out.println("Usercontroller.greet() :");

		return new User(99, "Dummy", "No gender", "Planet not found");
	}

	@GetMapping("/{id}")
	public User pathVariable(@PathVariable(name = "id") int id) {
		System.out.println("Usercontroller.pathVariable() :" + id);

		return users.get(id);
	}

	@GetMapping("/all-users")
	public Map<Integer, User> getAllUsers() {
		System.out.println("Usercontroller.getAllUsers()");

		return users;
	}

	@PostMapping
	public User saveUser(@RequestBody User user) {
		System.out.println("Usercontroller.saveUser :");
		System.out.println(user);

		users.put(user.getId(), user);

		return user;
	}  
	
	   @PutMapping("/{id}")
	    public User updateUser(@PathVariable(name = "id")int id,
	                           @RequestBody User user) {

	        if (users.containsKey(id)) {
	            user.setId(id);
	            users.put(id, user);
	            return user;
	        }

	        return null;
	}
	   @DeleteMapping("/{id}")
	    public User deleteUser(@PathVariable(name = "id")int id) {
	                           

	        return users.remove(id);
	}

		
 
}
