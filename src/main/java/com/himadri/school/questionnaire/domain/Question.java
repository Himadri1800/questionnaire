package com.himadri.school.questionnaire.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * @author Himadri Mandal
 *
 */

@Getter
@Setter
@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @NonNull
    String questionName;

    @NonNull
    String question;

    Set<Answer> answers;

    Set<Answer> correctAnswers;

    ZonedDateTime createdOn;

    ZonedDateTime modifiedOn;

    @Where(clause = "is_archived = false")
    Boolean isArchived;

    @PrePersist
    public void prePersist(){
        //todo
    }

    @PreUpdate
    public void preUpdate(){
        //todo update zonedatetime
    }

}
