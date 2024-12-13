package com.Quiz.QuizService.impl;

import com.Quiz.QuizService.entities.Quiz;
import com.Quiz.QuizService.repository.QuizRepository;
import com.Quiz.QuizService.services.QuestionClient;
import com.Quiz.QuizService.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class QuizServiceImpl implements QuizService {


    private QuizRepository quizRepository;
    private QuestionClient questionClient;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }



    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes = quizRepository.findAll();

        List<Quiz>newQuizList= quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        return quiz;
    }

    @Override
    public Quiz delete(Long id) {
         Quiz quiz = quizRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Quiz not found"));
    quizRepository.deleteById(id);
    return quiz;
    }
}
