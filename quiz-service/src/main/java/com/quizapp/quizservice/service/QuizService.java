package com.quizapp.quizservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.quizapp.quizservice.dao.QuizDao;
import com.quizapp.quizservice.feign.QuizInterface;
import com.quizapp.quizservice.model.QuestionWrapper;
import com.quizapp.quizservice.model.Quiz;
import com.quizapp.quizservice.model.Response;

public class QuizService {
	
	@Autowired
	QuizDao quizDao;

	@Autowired
	QuizInterface quizInterface;
	
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionIds(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Quiz quiz = quizDao.findById(id).get();
		List<Integer> questionIds = quiz.getQuestionIds();
		ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);
		return questions;
	}

	public ResponseEntity<Integer> caluculateResult(Integer id, List<Response> responses) {
		ResponseEntity<Integer> result = quizInterface.getScore(responses);
		return result;
	}

}
