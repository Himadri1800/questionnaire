package com.himadri.school.questionnaire.domain;

import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Himadri Mandal
 *
 */

@Getter
@Setter
@Data
@Entity
@EqualsAndHashCode(exclude = {"answers", "correctAnswers"})
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    private String questionName;

    @NonNull
    private String question;

    @OneToMany
    @JoinTable(
            name = "question_answer",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_id")
    )
    private Set<Answer> answers = new HashSet<>();

    @OneToMany
    @JoinTable(
            name = "question_correct",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_id")
    )
    private Set<Answer> correctAnswers = new HashSet<>();

    private ZonedDateTime createdOn;

    private ZonedDateTime modifiedOn;

    @Where(clause = "is_archived = false")
    private Boolean isArchived;

    @PrePersist
    public void prePersist(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        this.setCreatedOn(zonedDateTime);
    }

    @PreUpdate
    public void preUpdate(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        this.setModifiedOn(zonedDateTime);
    }

}
