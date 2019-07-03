package com.himadri.school.questionnaire.domain;

import com.himadri.school.questionnaire.domain.converter.QuestionConverter;
import com.himadri.school.questionnaire.domain.dto.QuestionDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuestionFactory {

    protected static QuestionConverter questionConverter = new QuestionConverter();

    public static QuestionDto getSingleQestion(){

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
        question.setAnswers(Arrays.asList(a,b,c,d).stream().collect(Collectors.toSet()));

        QuestionDto questionDto = questionConverter.convertToDTO(question);

        return questionDto;
    }
}
