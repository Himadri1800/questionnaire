package com.himadri.school.questionnaire.domain.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.himadri.school.questionnaire.domain.AnswerStatus;
import lombok.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonView
public class AnswerDTO implements Serializable {

    @JsonView
    private Long id;

    @JsonView
    private String answer;

    @JsonView
    private AnswerStatus answerStatus;

    @JsonView
    private Boolean isArchived;

    @JsonView
    private ZonedDateTime createdOn;

    @JsonView
    private ZonedDateTime updatedOn;
}
