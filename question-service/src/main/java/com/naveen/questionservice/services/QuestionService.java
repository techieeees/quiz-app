package com.naveen.questionservice.services;

import java.util.List;

import com.naveen.questionservice.dtos.QuestionWrapperDto;
import com.naveen.questionservice.models.Question;

public interface QuestionService {

	List<QuestionWrapperDto> getAllQuestions(String category);

	Question addQuestion(Question question);

}
