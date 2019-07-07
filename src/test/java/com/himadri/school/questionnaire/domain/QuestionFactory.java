package com.himadri.school.questionnaire.domain;

import com.himadri.school.questionnaire.domain.converter.QuestionConverter;
import com.himadri.school.questionnaire.domain.dto.QuestionDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class QuestionFactory {

    protected static QuestionConverter questionConverter = new QuestionConverter();

    public static QuestionDto getSingleQestion() {

        Question question = new Question();

        Answer a = new Answer();
        a.setAnswer("This is set answer A");
        a.setAnswerStatus(AnswerStatus.INCORRECT);

        Answer b = new Answer();
        b.setAnswer("This is set answer B");
        b.setAnswerStatus(AnswerStatus.INCORRECT);

        Answer c = new Answer();
        c.setAnswer("This is set answer C ");
        c.setAnswerStatus(AnswerStatus.INCORRECT);

        Answer d = new Answer();
        d.setAnswer("This is set answer D");
        d.setAnswerStatus(AnswerStatus.CORRECT);

        question.setQuestion("This is test question");
        question.setAnswers(Arrays.asList(a, b, c, d).stream().collect(Collectors.toSet()));

        QuestionDto questionDto = questionConverter.convertToDTO(question);

        return questionDto;
    }


    public static Set<Question> getQuestionSet() {

        Question q = new Question()
                .setQuestionName("Test Question1")
                .setQuestion("Test question details")
                .setStatus(QuestionStatus.DRAFTED);

        Question b = new Question()
                .setQuestion("test question 2")
                .setQuestionName("test question 2")
                .setStatus(QuestionStatus.PUBLISHED);

        Set<Question> questions = new HashSet<>();
        questions.addAll(Arrays.asList(q, b));

        return questions;
    }
}
