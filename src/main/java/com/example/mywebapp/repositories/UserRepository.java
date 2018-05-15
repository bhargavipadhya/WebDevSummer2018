package com.example.mywebapp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.mywebapp.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	/**
	 * FIND USER BY CREDENTIALS
	 * @param username
	 * @param password
	 */
	@Query("SELECT u FROM User u WHERE u.username=:username AND u.password=:password")
			Iterable<User> findUserByCredentials(
			@Param("username") String username, 
			@Param("password") String password);
	
	/**
	 * FIND USER BY USERNAME
	 * @param u
	 */
	@Query("SELECT u FROM User u WHERE u.username=:username")
			Iterable<User> findUserByUsername
			(@Param("username") String u);
}


