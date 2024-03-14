package com.telusko.quizapp.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {
    List<Question> findBycategory(String category);

    @Query(value ="SELECT * FROM question q where q.category=:category ORDER BY RANDOM() LIMIT :numQ" ,nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
