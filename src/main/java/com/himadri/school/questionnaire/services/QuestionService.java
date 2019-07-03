package com.himadri.school.questionnaire.services;

import com.himadri.school.questionnaire.domain.Question;
import com.himadri.school.questionnaire.repositories.QuestionRepository;
import com.himadri.school.questionnaire.utils.OperationNotPosibleException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Transactional
    public Question updateQuestion(Question question) throws OperationNotPosibleException {
        Question questionToUpdate = getQuestion(question.getId());
        return questionRepository.save(question);
    }

    @Transactional
    public void deleteQuestion(Long id) throws OperationNotPosibleException {
        Question questionToDelete = getQuestion(id);
        archiveQuestion(questionToDelete);
    }

    private Question getQuestion(Long id) throws OperationNotPosibleException{
        Question question = questionRepository.findById(id).orElseThrow(
                ()-> new OperationNotPosibleException("Not able to find the question by id :" + id)
        );
        return question;
    }


    private void archiveQuestion(Question question){
        question.setIsArchived(true);
        questionRepository.save(question);
    }
}
