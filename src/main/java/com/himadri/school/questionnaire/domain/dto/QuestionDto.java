package com.himadri.school.questionnaire.domain.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonView
@Accessors(chain = true)
public class QuestionDto implements Serializable {

    @JsonView
    private Long id;

    @JsonView
    private String questionName;

    @JsonView
    private String question;

    @JsonView
    private Set<AnswerDTO> answers = new HashSet<>();

    @JsonView
    private ZonedDateTime createdOn;

    @JsonView
    private ZonedDateTime modifiedOn;
}
