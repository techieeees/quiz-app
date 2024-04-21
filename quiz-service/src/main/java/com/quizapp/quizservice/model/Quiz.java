package com.quizapp.quizservice.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Entity
@Data
public class Quiz {
	
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String title;
	
	@ElementCollection
	private List<Integer> questionIds;
}
