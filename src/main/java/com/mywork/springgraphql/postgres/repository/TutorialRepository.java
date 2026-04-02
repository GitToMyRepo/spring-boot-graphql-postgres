package com.mywork.springgraphql.postgres.repository;

import com.mywork.springgraphql.postgres.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByAuthor_NameIgnoreCase(String authorName);
}
