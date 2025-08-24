package com.bezkoder.springgraphql.mysql.logging;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class GraphQLLoggingFilter extends OncePerRequestFilter {

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
        String reason = wrappedRequest.getHeader("X-Request-Reason");
        if (reason != null) {
            logger.info("Audit Header - X-Request-Reason: " + reason);
        }
        String responseBody = new String(wrappedResponse.getContentAsByteArray(), StandardCharsets.UTF_8);

        logger.info("Incoming GraphQL Request:\n" + requestBody);
        logger.info("Outgoing GraphQL Response:\n" + responseBody);

        wrappedResponse.copyBodyToResponse(); // Important: write response back to client
    }
}