package com.himadri.school.questionnaire.domain;

import com.himadri.school.questionnaire.AbstractTest;
import com.himadri.school.questionnaire.domain.converter.QuestionModuleConverter;
import com.himadri.school.questionnaire.domain.dto.QuestionModuleDTO;
import com.himadri.school.questionnaire.repositories.QuestionModuleRepository;
import com.himadri.school.questionnaire.repositories.QuestionRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

public class QuestionModuleControllerTest extends AbstractTest {


    @Autowired
    private QuestionModuleRepository moduleRepository;

    @Autowired
    private QuestionModuleConverter moduleConverter;

    @Before
    public void init(){
        super.setUp();
    }


    @Test
    public  void  createQuestionModuleTest() throws Exception{
        String url = "/module/create";
        //create module.
        QuestionModuleDTO moduleDTO = new QuestionModuleDTO()
                .setModuleName("Test question")
                .setDescription("Test description")
                .setIsArchived(false);

        String inputString = mapToJson(moduleDTO);

        MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .accept(MEDIA_TYPE_JSON_UTF8)
                .contentType(MEDIA_TYPE_JSON_UTF8)
                .content(inputString)
        ).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);

    }

    @Test
    public void deleteQuestionModuleTest() throws Exception{
        String url = "/module/delete";

        //adding Question to repository;
        QuestionModuleDTO moduleDTO = new QuestionModuleDTO()
                .setModuleName("Test question")
                .setDescription("Test description")
                .setIsArchived(false);

        QuestionModule module = moduleRepository.save(moduleConverter.convertToEntity(moduleDTO));


        MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url + "/" + module.getId())
        .contentType(MEDIA_TYPE_JSON_UTF8)
        .accept(MEDIA_TYPE_JSON_UTF8)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(202, status);
    }


}
