package com.reporting.demo.dto.common;

import java.util.Date;

public class ErrorDTO {
    private Date timestamp;
    private String message;
    private String details;

    public ErrorDTO(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
         return message;
    }

    public String getDetails() {
         return details;
    }
}