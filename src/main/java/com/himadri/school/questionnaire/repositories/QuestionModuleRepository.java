package com.himadri.school.questionnaire.repositories;

import com.himadri.school.questionnaire.domain.QuestionModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionModuleRepository extends JpaRepository<QuestionModule, Long> {

    List<QuestionModule> findByIsArchivedTrue();
}
