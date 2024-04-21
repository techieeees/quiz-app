package com.naveen.questionservice.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.questionservice.dtos.QuestionWrapperDto;
import com.naveen.questionservice.models.Question;
import com.naveen.questionservice.services.QuestionService;
import com.naveen.questionservice.utils.exceptions.QuestionAlreadyExistsException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("question")
@RequiredArgsConstructor
public class QuestionController {

	private final QuestionService questionService;

	@GetMapping(value = "allQuestions")
	public ResponseEntity<List<QuestionWrapperDto>> getAllQuestions(
			@RequestParam(name = "category", required = false) String category) {
		List<QuestionWrapperDto> questionDtos= questionService.getAllQuestions(category);
		return ResponseEntity.ok(questionDtos);
	}
	
	@PostMapping(value = "add")
	public ResponseEntity<Question> addQuestion(@RequestBody Question questiontoBeAdded){
		Question question= questionService.addQuestion(questiontoBeAdded);
		return ResponseEntity.status(HttpStatus.CREATED).body(question);
	}
	
	
	@ResponseStatus(value = HttpStatus.CONFLICT)
	@ExceptionHandler(QuestionAlreadyExistsException.class)
	public String handleQuestionAlreadyExistsException(QuestionAlreadyExistsException exception){
		return exception.getMessage();
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public String handleGenericExcepion(Exception exception) {
		exception.printStackTrace();
		return exception.getMessage();
	}
}
