package com.himadri.school.questionnaire.repositories;

import com.himadri.school.questionnaire.domain.QuestionModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionModuleRepository extends JpaRepository<QuestionModule, Long> {
}
