package com.example.mywebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.mywebapp.model.Widget;

public interface BaseWidgetRepository extends CrudRepository
<Widget, Integer>{
	
}
