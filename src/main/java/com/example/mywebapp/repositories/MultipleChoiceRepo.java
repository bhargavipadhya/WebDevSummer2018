package com.example.mywebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.mywebapp.model.MultipleChoiceQuestion;

public interface MultipleChoiceRepo extends CrudRepository<MultipleChoiceQuestion, Integer>{

}
