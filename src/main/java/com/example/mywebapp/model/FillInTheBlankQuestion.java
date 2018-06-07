package com.example.mywebapp.model;

import javax.persistence.Entity;

@Entity
public class FillInTheBlankQuestion extends Question{
	
	private String variables;
	private String fillvar;
	

	public String getFillvar() {
		return fillvar;
	}

	public void setFillvar(String fillvar) {
		this.fillvar = fillvar;
	}

	public String getVariables() {
		return variables;
	}

	public void setVariables(String variables) {
		this.variables = variables;
	}

}
