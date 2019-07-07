package com.himadri.school.questionnaire.domain;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Himadri
 */

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Accessors( chain = true)
@Table(name = "module")
public class QuestionModule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String moduleName;

    private String description;

    @OneToMany
    @JoinTable(
            name = "module_question",
            joinColumns = @JoinColumn(name = "module_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private Set<Question> questions = new HashSet<>();

    @Where(clause = "is_archived = false")
    private Boolean isArchived;

    private ZonedDateTime createdOn;

    private ZonedDateTime UpdatedOn;

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
