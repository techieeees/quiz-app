package com.naveen.questionservice.utils.exceptions;

public class QuestionAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public QuestionAlreadyExistsException(String message) {
		super(message);
	}
}
