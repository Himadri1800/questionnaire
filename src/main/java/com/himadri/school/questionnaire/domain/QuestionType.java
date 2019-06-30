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
public class QuestionType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String type;

    String description;

    ZonedDateTime createdOn;

    ZonedDateTime updatedOn;

    @PrePersist
    public void prepersist(){
        //todo
    }

    @PreUpdate
    public void preUpdate(){
        //todo
    }

}
