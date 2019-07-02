package com.himadri.school.questionnaire.controllers;

import com.himadri.school.questionnaire.domain.Question;
import com.himadri.school.questionnaire.domain.converter.QuestionConverter;
import com.himadri.school.questionnaire.domain.dto.QuestionDto;
import com.himadri.school.questionnaire.repositories.AnswerRepository;
import com.himadri.school.questionnaire.repositories.QuestionRepository;
import com.himadri.school.questionnaire.services.QuestionService;
import com.himadri.school.questionnaire.utils.OperationNotPosibleException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@Slf4j
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionConverter questionConverter;

    @RequestMapping(method = RequestMethod.GET)
    public String testController(){
        return "ok";
    }


    public Set<Question> getAllQuestion(){
        //todo
        return null;
    }

    public Set<Question> getAllQuestionByModule(){
        //todo

        return null;
    }

    @RequestMapping( path = "/" ,method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public QuestionDto addQuestion(@Valid @RequestBody QuestionDto questionDto){
        Question question = questionConverter.convertToEntity(questionDto);
        Question createdQuestion = questionService.createQuestion(question);

        return questionConverter.convertToDTO(createdQuestion);
    }

    @RequestMapping( path = "/update" , method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public QuestionDto updateQuestion(@Valid @RequestBody QuestionDto questionDto) throws OperationNotPosibleException {
        Question question = questionConverter.convertToEntity(questionDto);
        Question updatedQuestion = questionService.updateQuestion(question);
        return null;
    }

    @RequestMapping(path = "/delete/{id}" ,method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public void deleteQuestion(@PathVariable Long id) throws OperationNotPosibleException{
        questionService.deleteQuestion(id);
    }

}
