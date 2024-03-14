package com.telusko.quizapp.service;

import com.telusko.quizapp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;
    @Autowired
    QuestionRepo questionRepo;
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions=questionRepo.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);
        return new  ResponseEntity<>("success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz=quizRepo.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser= new ArrayList<>();
        for (Question q:questionsFromDB){
            QuestionWrapper qw =new QuestionWrapper(q.getId(),q.getQuestion_title(),q.getOption1(),q.getOption2());
            questionForUser.add(qw);
        }
        return new  ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz=quizRepo.findById(id).get();
        List<Question>questions=quiz.getQuestions();
        int right=0;
        int i=0;
        for (Response response:responses){
            if(response.getResponse().equals(questions.get(i).getRight_answer()))
                right++;
            i++;

        }
        return new ResponseEntity<>(right,HttpStatus.OK);

    }
}
