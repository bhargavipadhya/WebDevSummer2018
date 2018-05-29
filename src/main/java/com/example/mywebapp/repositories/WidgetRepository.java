package com.example.mywebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.mywebapp.model.Widget;

public interface WidgetRepository extends CrudRepository<Widget, Integer>{

}
