package com.Quiz.QuizService.controllers;

import com.Quiz.QuizService.entities.Quiz;
import com.Quiz.QuizService.services.QuizService;
import jakarta.persistence.Id;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private QuizService quizService;


    public QuizController(QuizService quizService) {

        this.quizService = quizService;
    }


//    create
    @PostMapping
    public Quiz create(@Validated @RequestBody Quiz quiz){
        return quizService.add(quiz);
    }

//    Get all
    @GetMapping
    public List<Quiz> get(){
        return quizService.get();
    }

//    Get one
    @GetMapping("/{id}")
    public Quiz getOne(@PathVariable Long id){
        return quizService.get(id);
    }

    // delete
    @DeleteMapping("/{id}")
    public Quiz delete (@PathVariable Long id){
        return quizService.delete(id);
    }

}
