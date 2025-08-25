package com.bezkoder.springgraphql.postgres.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class AuditLogDTO {
    private String requestReason;
    private String timestamp;

    public AuditLogDTO(String requestReason, LocalDateTime utcTimestamp) {
        this.requestReason = requestReason;
        this.timestamp = formatToBST(utcTimestamp);
    }

    public String getRequestReason() {
        return requestReason;
    }

    public String getTimestamp() {
        return timestamp;
    }

    private String formatToBST(LocalDateTime utcTimestamp) {
        ZonedDateTime bstTime = utcTimestamp.atZone(ZoneId.of("UTC"))
                .withZoneSameInstant(ZoneId.of("Europe/London"));
        return bstTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z"));
    }
}
