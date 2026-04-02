package com.mywork.springgraphql.postgres.repository;

import com.mywork.springgraphql.postgres.model.GraphQLAuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GraphQLAuditLogRepository extends JpaRepository<GraphQLAuditLog, Long> {

    List<GraphQLAuditLog> findByRequestReasonContainingIgnoreCase(String reason);

    @Query(value = "SELECT * FROM graphql_audit_log WHERE request_body->>'query' ILIKE %:queryFragment%", nativeQuery = true)
    List<GraphQLAuditLog> findByQueryFragment(@Param("queryFragment") String queryFragment);

    @Query(value = """
              SELECT * FROM graphql_audit_log
              WHERE jsonb_path_exists(
                response_body,
                '$.data.findAllTutorials[*].author.name ? (@ == $name)',
                jsonb_build_object('name', :authorName)
              )
            """, nativeQuery = true)
    List<GraphQLAuditLog> findByAuthorNameInResponse(@Param("authorName") String authorName);
}
