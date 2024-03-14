package com.telusko.quizapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String category;
    private String difficultylevel;
    private String option1;
    private String option2;
    private String question_title;
    private String right_answer;
    public static Question toEntity(QuestionDto dto){
        return Question.builder()
                .id(dto.getId())
                .category(dto.getCategory())
                .option1(dto.getOption1())
                .option2(dto.getOption2())
                .question_title(dto.getQuestion_title())
                .right_answer(dto.getRight_answer())
                .build();
    }
}
