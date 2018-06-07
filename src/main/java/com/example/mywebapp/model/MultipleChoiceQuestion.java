package com.example.mywebapp.model;

import javax.persistence.Entity;

@Entity
public class MultipleChoiceQuestion extends Question {
	
	private String correctchoice;
	private String options;
	
	
	
	public String getCorrectchoice() {
		return correctchoice;
	}
	public void setCorrectchoice(String correctchoice) {
		this.correctchoice = correctchoice;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}

}
