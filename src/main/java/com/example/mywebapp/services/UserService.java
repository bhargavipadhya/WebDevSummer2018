package com.example.mywebapp.services;

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

import com.example.mywebapp.repositories.UserRepository;

import com.example.mywebapp.model.User;


@RestController
public class UserService {

	@Autowired
	UserRepository repository;
	
	@PostMapping("/api/login")
	public User login(@RequestBody User user){
		List<User> list = (List<User>) repository.findUserByCredentials(user.getUsername(), user.getPassword());
		System.out.println(list.size());
		if(list.isEmpty())
			return null;
		else
			return list.get(0);
	}
	
	@PutMapping("/api/user/{userId}")
	public User updateUser(@PathVariable("userId") int userId, @RequestBody User newUser) {
		Optional<User> data = repository.findById(userId);
		if(data.isPresent()) {
		User user = data.get();
		user.setFirstName(newUser.getFirstName());
		repository.save(user);
		return user;
	}
		else
			return null;
	}
	
	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(@PathVariable("userId") int id) {
		repository.deleteById(id);
	}
	
	@PostMapping("/api/user")
	public User createUser(@RequestBody User user){
		return repository.save(user);	
	}
	
	// Register User
	@PostMapping("/api/register")
	public User register(@RequestBody User user){
		List<User> r = (List<User>) repository.findUserByUsername(user.getUsername());
		if(r.isEmpty()) {
			return repository.save(user);
		}
		else
			return null;
	}
	
	@GetMapping("/api/user")
	public List<User> findAllUsers(){
		return (List<User>) repository.findAll();
	}
	
	@GetMapping("/api/user/{userId}")
	public User findUserById(@PathVariable("userId") int userId){
		
		Optional<User> data = repository.findById(userId);
		if(data.isPresent()) {
		return data.get();
	}
		else
			return null;
	}
}
