package com.naveen.questionservice.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.naveen.questionservice.models.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
	
	@Query(value = "select q from Question q where :category is null or q.category=:category")
	List<Question> findByCategoryOrAll(@Param(value = "category") String category);

	@Query(value = "select 1 from Question q where q.title=:title")
	Optional<Integer> findByTitle(@Param(value = "title") String title);

}
