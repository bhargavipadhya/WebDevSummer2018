package com.example.mywebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.mywebapp.model.FillInTheBlankQuestion;

public interface FillInTheBlankRepo extends CrudRepository<FillInTheBlankQuestion, Integer>{

}
