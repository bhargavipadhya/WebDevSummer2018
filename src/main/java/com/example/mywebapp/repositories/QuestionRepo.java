package com.example.mywebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.mywebapp.model.Question;

public interface QuestionRepo extends CrudRepository<Question, Integer>{

}
