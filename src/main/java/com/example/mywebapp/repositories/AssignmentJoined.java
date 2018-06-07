package com.example.mywebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.mywebapp.model.Assignment;

public interface AssignmentJoined extends CrudRepository
<Assignment, Integer>{}

