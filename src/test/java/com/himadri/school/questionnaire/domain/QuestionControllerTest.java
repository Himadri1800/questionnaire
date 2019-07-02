package com.himadri.school.questionnaire.domain;

import com.himadri.school.questionnaire.AbstractTest;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuestionControllerTest extends AbstractTest {

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

    @Ignore("Need work here")
    public void addQuestionTest() throws Exception{
        String url = "/item/create";
    }


}
