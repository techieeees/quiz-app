package com.naveen.questionservice.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.naveen.questionservice.daos.QuestionDao;
import com.naveen.questionservice.dtos.QuestionWrapperDto;
import com.naveen.questionservice.models.Question;
import com.naveen.questionservice.utils.exceptions.QuestionAlreadyExistsException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
	private final ModelMapper modelMapper;
	private final QuestionDao questionDao;

	@Override
	public List<QuestionWrapperDto> getAllQuestions(String category) {
		List<Question> questions = questionDao.findByCategoryOrAll(category);
		List<QuestionWrapperDto> questionDtos = questions.stream()
				.map(question -> modelMapper.map(question, QuestionWrapperDto.class)).toList();
		return questionDtos;
	}

	@Override
	public Question addQuestion(Question questionToBeAdded) {
		Optional<Integer> optionalQuestion = questionDao.findByTitle(questionToBeAdded.getTitle());
		if (optionalQuestion.isPresent()) {
			throw new QuestionAlreadyExistsException("Question with the same title already exists");
		}
		Question questionAdded = questionDao.save(questionToBeAdded);
		return questionAdded;
	}

}
