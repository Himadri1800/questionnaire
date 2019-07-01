package com.himadri.school.questionnaire.controllers;

import com.himadri.school.questionnaire.domain.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@Slf4j
public class QuestionController {


    public Set<Question> getAllQuestion(){
        //todo
        return null;
    }

    public Set<Question> getAllQuestionByModule(){
        //todo

        return null;
    }

    public ResponseEntity<Question> addQuestion(){
        //todo
        return null;
    }

    public ResponseEntity<Question> updateQuestion(){
        //todo
        return null;
    }

    public ResponseEntity<Question> editQuestion(){
        //todo
        return null;
    }

}
