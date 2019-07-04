package com.himadri.school.questionnaire.services;

import com.himadri.school.questionnaire.domain.Question;
import com.himadri.school.questionnaire.domain.QuestionModule;
import com.himadri.school.questionnaire.repositories.QuestionModuleRepository;
import com.himadri.school.questionnaire.utils.OperationNotPosibleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionModuleService {

    @Autowired
    private QuestionModuleRepository moduleRepository;

    public QuestionModule createQuestionModule(QuestionModule questionModule) {
        return moduleRepository.save(questionModule);
    }


    @Transactional
    public QuestionModule editQuestionModule(QuestionModule questionModule) throws OperationNotPosibleException {
        QuestionModule module = getQuestionModule(questionModule.getId());
        return moduleRepository.save(questionModule);
    }

    @Transactional
    public void delete(Long id) throws OperationNotPosibleException {
        QuestionModule questionModule = getQuestionModule(id);
        archive(questionModule);
    }

    public QuestionModule getQuestionModule(Long id) throws OperationNotPosibleException {
        QuestionModule questionModule = moduleRepository.findById(id).orElseThrow(
                () -> new OperationNotPosibleException("Not able to find the question module by id: " + id)
        );
        return questionModule;
    }

    private void archive(QuestionModule module) throws OperationNotPosibleException {
        module.setIsArchived(true);
        moduleRepository.save(module);
    }

    public List<QuestionModule> getAllQuestionModule() {
        return moduleRepository.findAll();
    }

    public List<QuestionModule> getAllArchivedModule() {
        return moduleRepository.findByIsArchivedTrue();
    }

}
