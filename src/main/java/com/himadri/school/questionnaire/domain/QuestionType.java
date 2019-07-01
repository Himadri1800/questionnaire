package com.himadri.school.questionnaire.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@Data
@Entity
@Table(name = "question_type")
public class QuestionType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String type;

    private String description;

    private ZonedDateTime createdOn;

    private ZonedDateTime updatedOn;

    @PrePersist
    public void prepersist(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        this.setCreatedOn(zonedDateTime);
    }

    @PreUpdate
    public void preUpdate(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        this.setUpdatedOn(zonedDateTime);
    }

}
