package com.telusko.quizapp.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    private long id;
    private String category;
    private String difficultylevel;
    private String option1;
    private String option2;
    private String question_title;
    private String right_answer;

    public static QuestionDto toDto(Question entity){
        return QuestionDto.builder()
                .id(entity.getId())
                .category(entity.getCategory())
                .difficultylevel(entity.getDifficultylevel())
                .option1(entity.getOption1())
                .option2(entity.getOption2())
                .question_title(entity.getQuestion_title())
                .right_answer(entity.getRight_answer())
                .build();
    }
}
