package com.example.mywebapp.model;

import javax.persistence.Entity;

@Entity
public class TrueFalseQuestion extends Question {
	
	private boolean isTrue;
	
	// Getters and Setters
	public boolean isTrue() {
		return isTrue;
	}
	public void setTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}
}
