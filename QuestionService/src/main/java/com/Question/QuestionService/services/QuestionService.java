package com.Question.QuestionService.services;

import com.Question.QuestionService.entities.Question;

import java.util.List;

public interface QuestionService {

    Question create (Question question);

    List<Question> get();

    Question get(Long id);

    List<Question> getQuestionOfQuiz(Long quizId);
}
