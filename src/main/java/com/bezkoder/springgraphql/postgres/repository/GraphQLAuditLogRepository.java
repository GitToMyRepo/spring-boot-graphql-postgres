package com.bezkoder.springgraphql.postgres.repository;

import com.bezkoder.springgraphql.postgres.model.GraphQLAuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraphQLAuditLogRepository extends JpaRepository<GraphQLAuditLog, Long> {
}
