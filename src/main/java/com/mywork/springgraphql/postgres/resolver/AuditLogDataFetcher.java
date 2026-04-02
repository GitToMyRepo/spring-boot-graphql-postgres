package com.mywork.springgraphql.postgres.resolver;

import com.mywork.springgraphql.postgres.dto.AuditLogDTO;
import com.mywork.springgraphql.postgres.repository.GraphQLAuditLogRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class AuditLogDataFetcher {
    private static final Logger logger = LoggerFactory.getLogger(AuditLogDataFetcher.class);

    private final GraphQLAuditLogRepository auditLogRepository;

    public AuditLogDataFetcher(GraphQLAuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @DgsQuery
    public List<AuditLogDTO> getRequestReasons(@InputArgument String reasonFragment) {
        logger.info("Calling getRequestReasons. Reason Fragment: {}", reasonFragment);
        return auditLogRepository.findByQueryFragment(reasonFragment)
                .stream()
                .map(log -> new AuditLogDTO(log.getRequestReason(), log.getTimestamp()))
                .collect(Collectors.toList());
    }

    @DgsQuery
    public List<AuditLogDTO> getRequestReasonsByAuthor(@InputArgument String authorName) {
        logger.info("Filtering audit logs by author name: {}", authorName);
        return auditLogRepository.findByAuthorNameInResponse(authorName)
                .stream()
                .map(log -> new AuditLogDTO(log.getRequestReason(), log.getTimestamp()))
                .collect(Collectors.toList());
    }
}
