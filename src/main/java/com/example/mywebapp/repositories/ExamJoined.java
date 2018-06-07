package com.example.mywebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.mywebapp.model.Exam;

public interface ExamJoined extends CrudRepository
<Exam, Integer>{}

