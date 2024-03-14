package com.telusko.quizapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionWrapper {
    private long id;
    private String questionTitle;
    private String option1;
    private String option2;

    public QuestionWrapper(long id, String questionTitle, String option1, String option2) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
    }
}
