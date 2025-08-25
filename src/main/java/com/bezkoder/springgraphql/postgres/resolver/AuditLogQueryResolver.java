package com.bezkoder.springgraphql.postgres.resolver;

import com.bezkoder.springgraphql.postgres.dto.AuditLogDTO;
import com.bezkoder.springgraphql.postgres.repository.GraphQLAuditLogRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuditLogQueryResolver implements GraphQLQueryResolver {
    private static final Logger logger = LoggerFactory.getLogger(AuditLogQueryResolver.class);

    private GraphQLAuditLogRepository auditLogRepository;

    @Autowired
    public AuditLogQueryResolver(GraphQLAuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    public List<AuditLogDTO> getRequestReasons(String reasonFragment) {
        logger.info("Calling getRequestReasons. Reason Fregment: {}", reasonFragment);
        return auditLogRepository.findByQueryFragment(reasonFragment)
                .stream()
                .map(log -> new AuditLogDTO(log.getRequestReason(), log.getTimestamp()))
                .collect(Collectors.toList());
    }

    public List<AuditLogDTO> getRequestReasonsByAuthor(String authorName) {
        logger.info("Filtering audit logs by author name: {}", authorName);
        return auditLogRepository.findByAuthorNameInResponse(authorName)
                .stream()
                .map(log -> new AuditLogDTO(log.getRequestReason(), log.getTimestamp()))
                .collect(Collectors.toList());
    }
}