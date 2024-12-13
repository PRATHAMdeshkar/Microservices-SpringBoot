package com.Question.QuestionService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long questionId;

        private String question;

        private Long quizId;

        public Long getQuizId() {
                return quizId;
        }

        public void setQuizId(Long quizId) {
                this.quizId = quizId;
        }

        public String getQuestion() {
                return question;
        }

        public void setQuestion(String question) {
                this.question = question;
        }
}
