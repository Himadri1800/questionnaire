package com.himadri.school.questionnaire.domain;

import lombok.*;
import lombok.experimental.Accessors;
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
@EqualsAndHashCode(exclude = {"answers"})
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table( name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String questionName;

    @NonNull
    private String question;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "question_answer",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_id")
    )
    private Set<Answer> answers = new HashSet<>();

    private QuestionStatus status;

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
