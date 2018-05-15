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
	
	// LOGIN USER
	@PostMapping("/api/login")
	public User login(@RequestBody User user){
		List<User> list = (List<User>) repository.findUserByCredentials(user.getUsername(), user.getPassword());
		System.out.println(list.size());
		if(list.isEmpty())
			return null;
		else
			return list.get(0);
	}
	
	// UPDATE USER
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
	
	// UPDATE PROFILE
	@PutMapping("/api/profile")
	public User updateProfile(@RequestBody User newProfile) {
		List<User> l = (List<User>) repository.findUserByUsername(newProfile.getUsername());
		User data=l.get(0);
		data.setPhone(newProfile.getPhone());
		data.setEmail(newProfile.getEmail());
		data.setRole(newProfile.getRole());
		data.setdOB(newProfile.getdOB());
		repository.save(data);
		return newProfile;
	
	}
	
	// DELETE USER
	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(@PathVariable("userId") int id) {
		repository.deleteById(id);
	}
	
	// CREATE USER
	@PostMapping("/api/user")
	public User createUser(@RequestBody User user){
		return repository.save(user);	
	}
	
	// REGISTER NEW USER
	@PostMapping("/api/register")
	public User register(@RequestBody User user){
		List<User> r = (List<User>) repository.findUserByUsername(user.getUsername());
		if(r.isEmpty()) {
			return repository.save(user);
		}
		else
			return null;
	}
	
	// FIND ALL THE USERS
	@GetMapping("/api/user")
	public List<User> findAllUsers(){
		return (List<User>) repository.findAll();
	}
	
	// FIND A USER BY THEIR ID
	@GetMapping("/api/user/{userId}")
	public User findUserById(@PathVariable("userId") int userId){
		
		Optional<User> data = repository.findById(userId);
		if(data.isPresent()) {
			//System.out.println(data.get().getUsername());
		return data.get();
	}
		else
			return null;
	}


	// FIND A USER BY THEIR USERNAME
	@GetMapping("/api/profile/{value}")
	public User findUserByUsername(@PathVariable("value") String val){
		List<User> l = (List<User>) repository.findUserByUsername(val);
		if(l.isEmpty()) {
			return null;
	}
		else
			return l.get(0);
	}
}
