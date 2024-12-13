package com.Question.QuestionService.controllers;

import com.Question.QuestionService.entities.Question;
import com.Question.QuestionService.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

//    create

    @PostMapping
    public Question create(@Validated @RequestBody Question question){
        return questionService.create(question);
    }

//    get all

    @GetMapping
    public List<Question> get(){
        return questionService.get();
    }

    public Question getALL(@PathVariable Long questionId){
        return questionService.get(questionId);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionOfQuiz(@PathVariable Long quizId){
        return questionService.getQuestionOfQuiz(quizId);
    }
}

