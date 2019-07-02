package com.himadri.school.questionnaire.domain;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author Himadri
 */

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String answer;

    private Boolean isArchived;

    private ZonedDateTime createdOn;

    private ZonedDateTime updatedOn;

    @PrePersist
    public void prePersist(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        this.setCreatedOn(zonedDateTime);
    }

    @PreUpdate
    public void preUpdate(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        this.setUpdatedOn(zonedDateTime);
    }

}
