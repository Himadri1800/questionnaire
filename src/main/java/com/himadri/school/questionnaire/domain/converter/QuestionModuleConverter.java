package com.himadri.school.questionnaire.domain.converter;

import com.himadri.school.questionnaire.domain.QuestionModule;
import com.himadri.school.questionnaire.domain.dto.QuestionModuleDTO;
import com.himadri.school.questionnaire.services.QuestionModuleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionModuleConverter {

    private ModelMapper modelMapper;

    @Autowired
    public QuestionModuleConverter(){
        modelMapper = new ModelMapper();
    }

    public QuestionModule convertToEntity(QuestionModuleDTO moduleDTO){
        return modelMapper.map(moduleDTO, QuestionModule.class);
    }

    public QuestionModuleDTO convertToDTO(QuestionModule questionModule){
        return modelMapper.map(questionModule, QuestionModuleDTO.class);
    }

}
