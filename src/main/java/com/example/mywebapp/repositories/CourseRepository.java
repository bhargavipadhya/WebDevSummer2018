package com.example.mywebapp.repositories;


import org.springframework.data.repository.CrudRepository;
import com.example.mywebapp.model.Course;

public interface CourseRepository
extends CrudRepository<Course, Integer> { }

