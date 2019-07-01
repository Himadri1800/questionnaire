package com.himadri.school.questionnaire.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Himadri
 */

@Getter
@Setter
@Data
@Entity
@Table(name = "question_module")
public class QuestionModule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String moduleName;

    private String description;
}
