package com.bezkoder.springgraphql.postgres.logging;

import com.bezkoder.springgraphql.postgres.model.GraphQLAuditLog;
import com.bezkoder.springgraphql.postgres.repository.GraphQLAuditLogRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Component
public class GraphQLLoggingFilter extends OncePerRequestFilter {
    @Autowired
    private GraphQLAuditLogRepository auditLogRepository;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !request.getRequestURI().contains("/apis/graphql");
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response);

        filterChain.doFilter(wrappedRequest, wrappedResponse);

        String requestBody = new String(wrappedRequest.getContentAsByteArray(), StandardCharsets.UTF_8);
        String responseBody = new String(wrappedResponse.getContentAsByteArray(), StandardCharsets.UTF_8);
        String reason = wrappedRequest.getHeader("X-Request-Reason");
        String clientIp = request.getRemoteAddr();

        GraphQLAuditLog log = new GraphQLAuditLog();
        log.setRequestBody(requestBody);
        log.setResponseBody(responseBody);
        log.setRequestReason(reason);
        log.setClientIp(clientIp);
        log.setTimestamp(LocalDateTime.now());

        auditLogRepository.save(log);

        wrappedResponse.copyBodyToResponse();
    }
}