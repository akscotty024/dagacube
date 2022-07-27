package com.dagacube.casino.exception;

import java.util.Date;

public class ErrorDetails {
   // This class is used as part of error handling it contains the time stamp a special message you set in your controller and the detail thereof.
	private Date timestamp;
    private String message;
    private String details;

    public ErrorDetails(Date timestamp, String message, String details) {
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
