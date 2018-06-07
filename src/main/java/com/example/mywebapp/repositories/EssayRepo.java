package com.example.mywebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.mywebapp.model.EssayQuestion;

public interface EssayRepo extends CrudRepository<EssayQuestion, Integer>{

}
