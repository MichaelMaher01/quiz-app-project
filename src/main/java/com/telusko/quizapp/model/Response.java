package com.telusko.quizapp.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Response {
    private Integer id;
    private String response;
}
