package com.himadri.school.questionnaire.domain;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * @author Himadri
 * This will the sample test paper where one can create its own sets of questions.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "test")
public class TestSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    private String TestName;

    private String Description;

    @OneToMany
    @JoinTable(
            name = "test_question",
            joinColumns = @JoinColumn(name = "test_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private Set<Question> questions;

    private ZonedDateTime createdOn;

    private ZonedDateTime updateOn;

    private TestType testType;

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
