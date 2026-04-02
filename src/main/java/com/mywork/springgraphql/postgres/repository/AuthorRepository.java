package com.mywork.springgraphql.postgres.repository;

import com.mywork.springgraphql.postgres.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
