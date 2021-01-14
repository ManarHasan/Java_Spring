package com.axsos.dojooverflow.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class CustomValid {
	@Size(max=255)
	@NotBlank()
	private String questionText;
	@Pattern(regexp = "^(([a-z\\s])+$|([a-z\\s]+,)[a-z\\s]+){1,2}$" , message="must have a comma and be lowercase and max 3")
	private String Subject;
	public CustomValid() {}
	public CustomValid(String questionText, String subject) {
		super();
		this.questionText = questionText;
		Subject = subject;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	
}
