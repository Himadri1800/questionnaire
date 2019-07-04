package com.himadri.school.questionnaire.domain.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.himadri.school.questionnaire.domain.Question;
import lombok.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Set;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionModuleDTO implements Serializable {

    @JsonView
    private Long id;

    @JsonView
    private String moduleName;

    @JsonView
    private String description;

    @JsonView
    private Set<Question> questions;

    @JsonView
    private Boolean isArchived;

    @JsonView
    private ZonedDateTime createdOn;

    @JsonView
    private ZonedDateTime UpdatedOn;
}
