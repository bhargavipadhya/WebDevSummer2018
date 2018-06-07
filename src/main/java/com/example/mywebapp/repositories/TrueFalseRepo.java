package com.example.mywebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.mywebapp.model.TrueFalseQuestion;

public interface TrueFalseRepo extends CrudRepository<TrueFalseQuestion, Integer>{

}
