package com.example.mywebapp.repositories;
import com.example.mywebapp.model.Topic;
import org.springframework.data
  .repository.CrudRepository;

public interface TopicRepository
  extends CrudRepository<Topic, Integer>{}


