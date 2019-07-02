package com.himadri.school.questionnaire.domain.converter;

import com.himadri.school.questionnaire.domain.Question;
import com.himadri.school.questionnaire.domain.dto.QuestionDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionConverter {


    private ModelMapper modelMapper;

    @Autowired
    public QuestionConverter(){
        modelMapper = new ModelMapper();
    }


    public Question convertToEntity(QuestionDto questionDto){
        return modelMapper.map(questionDto, Question.class);
    }

    public QuestionDto convertToDTO(Question question){
        return modelMapper.map(question, QuestionDto.class);
    }
}
