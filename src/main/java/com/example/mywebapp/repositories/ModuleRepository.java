package com.example.mywebapp.repositories;
import com.example.mywebapp.model.Module;
import org.springframework.data
  .repository.CrudRepository;

public interface ModuleRepository
  extends CrudRepository<Module, Integer>{}

