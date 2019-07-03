package com.himadri.school.questionnaire.domain;

import com.himadri.school.questionnaire.AbstractTest;
import com.himadri.school.questionnaire.domain.converter.QuestionConverter;
import com.himadri.school.questionnaire.domain.dto.AnswerDTO;
import com.himadri.school.questionnaire.domain.dto.QuestionDto;
import com.himadri.school.questionnaire.repositories.QuestionRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static com.himadri.school.questionnaire.domain.QuestionFactory.getSingleQestion;

public class QuestionControllerTest extends AbstractTest {


    @Autowired
    private QuestionConverter questionConverter;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testControllerTest() throws Exception {
        String url = "/question";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url)
        .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

    }

    @Test
    public void addQuestionTest() throws Exception{
        String url = "/question/create";

        QuestionDto questionDto = getSingleQestion();

        String inputString = mapToJson(questionDto);

        MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .accept(MEDIA_TYPE_JSON_UTF8)
                .contentType(MEDIA_TYPE_JSON_UTF8)
                .content(inputString)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);

        String content = mvcResult.getResponse().getContentAsString();
        QuestionDto savedQuestion = mapFromJson(content, QuestionDto.class);
        assertEquals(questionDto.getQuestion(),savedQuestion.getQuestion());
        //todo add other parameters to test here.

    }

    @Test
    public void updateQuestionTest() throws Exception{
        String url = "/question/update";

        QuestionDto questionDto = getSingleQestion();
        Question question = questionConverter.convertToEntity(questionDto);
        Question createdQuestion = questionRepository.save(question);

        //updating the question
        QuestionDto createdQuestionDto = questionConverter.convertToDTO(createdQuestion);
        createdQuestionDto.setQuestion("Updated Question");
        createdQuestionDto.setQuestionName("Added Question name as well");

        //test the updated question
        String inputString = mapToJson(createdQuestionDto);
        MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(url)
        .accept(MEDIA_TYPE_JSON_UTF8)
        .content(inputString)
        .contentType(MEDIA_TYPE_JSON_UTF8)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(202,status);

        String content = mvcResult.getResponse().getContentAsString();
        QuestionDto updatedQuestion = mapFromJson(content, QuestionDto.class);

        assertEquals(createdQuestionDto.getQuestion(), updatedQuestion.getQuestion());
        assertEquals(createdQuestionDto.getQuestionName(),updatedQuestion.getQuestionName());
        assertNotNull(updatedQuestion.getModifiedOn());

    }

    @Test
    public void deleteQuestionTest() throws Exception{
        String url = "/question/delete";

        QuestionDto questionDto = getSingleQestion();
        Question question = questionConverter.convertToEntity(questionDto);
        Question createdQuestion = questionRepository.save(question);

        MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url + "/" + createdQuestion.getId())
        .contentType(MEDIA_TYPE_JSON_UTF8)
        .accept(MEDIA_TYPE_JSON_UTF8)).andReturn();

        int status = mvcResult.getResponse().getStatus();

        assertEquals(202, status);

    }


}
