package com.telusko.quizapp.service;

import com.telusko.quizapp.model.Question;
import com.telusko.quizapp.model.QuestionDto;
import com.telusko.quizapp.model.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo questionRepo;

    public  ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK) ;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK) ;
//        if(QuestionDto.is)

    }


    public ResponseEntity<List<Question>> getAllQuestions() {
       try {
           return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK) ;
       }catch (Exception e){
           e.printStackTrace();
       }
        return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK) ;

    }
    public ResponseEntity<String> addQuestion(Question question) {
        questionRepo.save(question);
        return new ResponseEntity<>("success",HttpStatus.CREATED);


    }
}
