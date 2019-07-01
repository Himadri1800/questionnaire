package com.himadri.school.questionnaire.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * @author Himadri
 * This will the sample test paper where one can create its own sets of questions.
 */

@Getter
@Setter
@Entity
@Table(name = "test")
public class TestSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @NonNull
    String TestName;

    String Description;

    Set<Question> questions;

    ZonedDateTime createdOn;

    ZonedDateTime updateOn;

    TestType testType;

    @PrePersist
    public void prePersist(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        this.setCreatedOn(zonedDateTime);
    }

    @PreUpdate
    public  void preUpdate(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        this.setUpdateOn(zonedDateTime);
    }

}
