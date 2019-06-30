package com.himadri.school.questionnaire.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author Himadri
 */

@Getter
@Setter
@Data
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String answer;

    Boolean isArchived;

    Date createdOn;

    ZonedDateTime updatedOn;

    @PrePersist
    public void prePersist(){
        //todo update the ZonedateTime
    }

    @PreUpdate
    public void preUpdate(){
        //todo update the zonedatetime
    }

}
