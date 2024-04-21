package com.naveen.questionservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "QUESTION")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "CATEGORY", nullable = false)
	private String category;
	
	@Column(name = "TITLE", unique = true, nullable = false)
	private String title;
	
	@Column(name = "DIFFICULTY_LEVEL", nullable = false)
	private String difficultyLevel;
	
	@Column(name = "OPTION_A", nullable = false)
	private String optionA;
	
	@Column(name = "OPTION_B", nullable = false)
	private String optionB;
	
	@Column(name = "OPTION_C", nullable = false)
	private String optionC;
	
	@Column(name = "OPTION_D", nullable = false)
	private String optionD;
	
	@Column(name = "ANSWER", nullable = false)
	private Character answer;
}
