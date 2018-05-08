package com.example.mywebapp.repositories;


import org.springframework.data.repository.CrudRepository;

import com.example.mywebapp.model.Hello;

public interface HelloRepository
extends CrudRepository<Hello, Integer> {}
