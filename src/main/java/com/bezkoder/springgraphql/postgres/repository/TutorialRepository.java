package com.bezkoder.springgraphql.postgres.repository;

import com.bezkoder.springgraphql.postgres.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}
