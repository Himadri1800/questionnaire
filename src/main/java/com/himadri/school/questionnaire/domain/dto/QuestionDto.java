package com.himadri.school.questionnaire.domain.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.himadri.school.questionnaire.domain.Answer;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@JsonView
public class QuestionDto implements Serializable {

    private Long id;

    private String questionName;

    private String question;

    private Set<Answer> answers = new HashSet<>();

    private Set<Answer> correctAnswers = new HashSet<>();

    private ZonedDateTime createdOn;

    private ZonedDateTime modifiedOn;
}
