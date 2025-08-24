package com.bezkoder.springgraphql.postgres.repository;

import com.bezkoder.springgraphql.postgres.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}