package com.example.mywebapp.repositories;
import com.example.mywebapp.model.Lesson;
import org.springframework.data
  .repository.CrudRepository;

public interface LessonRepository
  extends CrudRepository<Lesson, Integer>{}


