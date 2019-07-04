package com.himadri.school.questionnaire.controllers;

import com.himadri.school.questionnaire.domain.Question;
import com.himadri.school.questionnaire.domain.QuestionModule;
import com.himadri.school.questionnaire.domain.converter.QuestionModuleConverter;
import com.himadri.school.questionnaire.domain.dto.QuestionModuleDTO;
import com.himadri.school.questionnaire.services.QuestionModuleService;
import com.himadri.school.questionnaire.utils.OperationNotPosibleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author Himadri Mandal
 * This is specific module where all Question belongs to one single module;
 * Pending test cases.
 */

@RestController
@RequestMapping( "/module")
public class QuestionModuleController {

    @Autowired
    private QuestionModuleService moduleService;

    @Autowired
    private QuestionModuleConverter moduleConverter;

    public Set<Question> getAllQuestionByModule(){
        //todo
        return null;
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public QuestionModuleDTO createQuestionModule(@RequestBody QuestionModuleDTO moduleDTO){
        QuestionModule questionModule = moduleConverter.convertToEntity(moduleDTO);
        QuestionModule createdQuestion =  moduleService.createQuestionModule(questionModule);
        return moduleConverter.convertToDTO(createdQuestion);
    }

    @RequestMapping( path = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public QuestionModule deleteQuestionModule(@PathVariable Long id) throws OperationNotPosibleException {
        moduleService.delete(id);
        return null;
    }

    @RequestMapping( path = "/update", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public QuestionModuleDTO editQuestionModule(@RequestBody QuestionModuleDTO moduleDTO) throws OperationNotPosibleException{
        QuestionModule module = moduleConverter.convertToEntity(moduleDTO);
        QuestionModule updatedModule = moduleService.editQuestionModule(module);
        return moduleConverter.convertToDTO(updatedModule);
    }

}
